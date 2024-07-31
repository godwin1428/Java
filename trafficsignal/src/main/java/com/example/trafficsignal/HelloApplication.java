package com.example.trafficsignal;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {

    // Constants for traffic signal optimization
    private static final int TOTAL_CYCLE_TIME = 120; // Total cycle time in seconds
    private static final int YELLOW_TIME = 5;       // Standard yellow time in seconds
    private static final int PEDESTRIAN_TIME_PER_PERSON = 3; // Time per pedestrian in seconds

    @Override
    public void start(Stage primaryStage) {
        // Create the traffic light circles
        Circle redLight = new Circle(50, Color.RED);
        Circle yellowLight = new Circle(50, Color.GRAY);
        Circle greenLight = new Circle(50, Color.GRAY);

        // Create labels for optimization metrics
        Label timingsLabel = new Label();
        Label metricsLabel = new Label();

        // Arrange the circles and labels in a vertical layout
        VBox root = new VBox(10);
        root.getChildren().addAll(redLight, yellowLight, greenLight, timingsLabel, metricsLabel);

        // Create the scene and set the stage
        Scene scene = new Scene(root, 300, 600);
        primaryStage.setTitle("Traffic Signal Animation and Optimization");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Example input data for optimization
        int[] queueLengths = {150, 120, 200, 180}; // Queue lengths for Northbound, Southbound, Eastbound, Westbound
        int totalVehicles = 650; // Total number of vehicles across all lanes
        double peakHourAdjustmentFactor = 1.2; // Adjust for peak hours (1.2 for peak hours, 1.0 otherwise)
        int pedestrianDemand = 10; // Number of pedestrians waiting to cross

        // Compute optimized timings for the first lane only (e.g., Northbound)
        int laneIndex = 0; // Index for the lane you want to display (0 = Northbound)
        int[] greenTimes = computeGreenTimes(queueLengths, totalVehicles, peakHourAdjustmentFactor);
        int[] redTimes = computeRedTimes(greenTimes);
        int pedestrianTime = computePedestrianTime(pedestrianDemand);

        // Adjust for pedestrian crossing
        int adjustedCycleTime = TOTAL_CYCLE_TIME - pedestrianTime;
        int[] adjustedGreenTimes = adjustGreenTimesForCycleTime(greenTimes, adjustedCycleTime);

        // Metrics calculations for the selected lane
        double averageTravelTimeBefore = computeAverageTravelTime(queueLengths, greenTimes);
        double averageTravelTimeAfter = computeAverageTravelTime(queueLengths, adjustedGreenTimes);
        double trafficFlowImprovement = computeTrafficFlowImprovement(averageTravelTimeBefore, averageTravelTimeAfter);
        double averageWaitTimeBefore = computeAverageWaitTime(queueLengths, greenTimes);
        double averageWaitTimeAfter = computeAverageWaitTime(queueLengths, adjustedGreenTimes);
        double waitTimeReduction = computeWaitTimeReduction(averageWaitTimeBefore, averageWaitTimeAfter);
        double queueLengthBefore = totalVehicles;
        double queueLengthAfter = computeTotalQueueLength(adjustedGreenTimes);
        double congestionReduction = computeCongestionReduction(queueLengthBefore, queueLengthAfter);

        // Update labels with results for the selected lane
        timingsLabel.setText(generateTimingsText(laneIndex, adjustedGreenTimes[laneIndex], redTimes[laneIndex], pedestrianTime));
        metricsLabel.setText(generateMetricsText(
                averageTravelTimeBefore, averageTravelTimeAfter,
                trafficFlowImprovement, averageWaitTimeBefore, averageWaitTimeAfter,
                waitTimeReduction, queueLengthBefore, queueLengthAfter, congestionReduction
        ));

        // Create a timeline for the animation
        Timeline timeline = new Timeline(
                // Initial state: Red light on
                new KeyFrame(Duration.seconds(0), e -> {
                    redLight.setFill(Color.RED);
                    yellowLight.setFill(Color.GRAY);
                    greenLight.setFill(Color.GRAY);
                }),
                // Yellow light on after red
                new KeyFrame(Duration.seconds(adjustedGreenTimes[laneIndex]), e -> {
                    redLight.setFill(Color.GRAY);
                    yellowLight.setFill(Color.YELLOW);
                    greenLight.setFill(Color.GRAY);
                }),
                // Green light on after yellow
                new KeyFrame(Duration.seconds(adjustedGreenTimes[laneIndex] + YELLOW_TIME), e -> {
                    redLight.setFill(Color.GRAY);
                    yellowLight.setFill(Color.GRAY);
                    greenLight.setFill(Color.GREEN);
                }),
                // Yellow light on after green
                new KeyFrame(Duration.seconds(adjustedGreenTimes[laneIndex] + YELLOW_TIME + greenTimes[laneIndex]), e -> {
                    redLight.setFill(Color.GRAY);
                    yellowLight.setFill(Color.YELLOW);
                    greenLight.setFill(Color.GRAY);
                }),
                // Red light on after yellow
                new KeyFrame(Duration.seconds(adjustedGreenTimes[laneIndex] + YELLOW_TIME + greenTimes[laneIndex] + YELLOW_TIME), e -> {
                    redLight.setFill(Color.RED);
                    yellowLight.setFill(Color.GRAY);
                    greenLight.setFill(Color.GRAY);
                })
        );


        // Set the cycle count to indefinite to keep the animation running
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    // Compute green times for each lane
    public static int[] computeGreenTimes(int[] queueLengths, int totalVehicles, double peakHourAdjustmentFactor) {
        int[] greenTimes = new int[queueLengths.length];
        int totalQueue = 0;

        // Calculate total queue length
        for (int queueLength : queueLengths) {
            totalQueue += queueLength;
        }

        // Calculate green times
        for (int i = 0; i < queueLengths.length; i++) {
            greenTimes[i] = (int) ((queueLengths[i] * peakHourAdjustmentFactor / (double) totalQueue) * (TOTAL_CYCLE_TIME - YELLOW_TIME));
        }

        return greenTimes;
    }

    // Compute red times based on green times and yellow time
    public static int[] computeRedTimes(int[] greenTimes) {
        int[] redTimes = new int[greenTimes.length];
        for (int i = 0; i < greenTimes.length; i++) {
            redTimes[i] = TOTAL_CYCLE_TIME - greenTimes[i] - YELLOW_TIME;
        }
        return redTimes;
    }

    // Compute pedestrian crossing time
    public static int computePedestrianTime(int pedestrianDemand) {
        return pedestrianDemand * PEDESTRIAN_TIME_PER_PERSON;
    }

    // Adjust green times based on the adjusted cycle time
    public static int[] adjustGreenTimesForCycleTime(int[] greenTimes, int adjustedCycleTime) {
        int[] adjustedGreenTimes = new int[greenTimes.length];
        for (int i = 0; i < greenTimes.length; i++) {
            adjustedGreenTimes[i] = (int) ((greenTimes[i] / (double) (TOTAL_CYCLE_TIME - YELLOW_TIME)) * adjustedCycleTime);
        }
        return adjustedGreenTimes;
    }

    // Compute average travel time before and after optimization
    public static double computeAverageTravelTime(int[] queueLengths, int[] greenTimes) {
        double totalTravelTime = 0;
        for (int i = 0; i < queueLengths.length; i++) {
            double travelTime = (double) queueLengths[i] / (greenTimes[i] / (double) TOTAL_CYCLE_TIME);
            totalTravelTime += travelTime;
        }
        return totalTravelTime / queueLengths.length;
    }

    // Compute traffic flow improvement
    public static double computeTrafficFlowImprovement(double averageTravelTimeBefore, double averageTravelTimeAfter) {
        return (averageTravelTimeAfter - averageTravelTimeBefore) / averageTravelTimeBefore * 100;
    }

    // Compute average wait time
    public static double computeAverageWaitTime(int[] queueLengths, int[] greenTimes) {
        double totalWaitTime = 0;
        for (int i = 0; i < queueLengths.length; i++) {
            double waitTime = (double) queueLengths[i] * TOTAL_CYCLE_TIME / (greenTimes[i] + YELLOW_TIME);
            totalWaitTime += waitTime;
        }
        return totalWaitTime / queueLengths.length;
    }

    // Compute wait time reduction
    public static double computeWaitTimeReduction(double averageWaitTimeBefore, double averageWaitTimeAfter) {
        return (averageWaitTimeBefore - averageWaitTimeAfter) / averageWaitTimeBefore * 100;
    }

    // Compute total queue length based on green times
    public static double computeTotalQueueLength(int[] greenTimes) {
        double totalQueue = 0;
        for (int greenTime : greenTimes) {
            totalQueue += TOTAL_CYCLE_TIME / (double) greenTime;
        }
        return totalQueue;
    }

    // Compute congestion reduction
    public static double computeCongestionReduction(double queueLengthBefore, double queueLengthAfter) {
        return (queueLengthBefore - queueLengthAfter) / queueLengthBefore * 100;
    }

    // Generate text for timings for a specific lane
    public static String generateTimingsText(int laneIndex, int greenTime, int redTime, int pedestrianTime) {
        return String.format("Optimized Timings for Lane %d:\n" +
                        "Red Time: %d seconds\n" +
                        "Yellow Time: %d seconds\n" +
                        "Green Time: %d seconds\n" +
                        "Pedestrian Time: %d seconds\n",
                laneIndex + 1, greenTime, YELLOW_TIME, redTime, pedestrianTime);
    }

    // Generate text for metrics
    public static String generateMetricsText(
            double averageTravelTimeBefore, double averageTravelTimeAfter,
            double trafficFlowImprovement, double averageWaitTimeBefore, double averageWaitTimeAfter,
            double waitTimeReduction, double queueLengthBefore, double queueLengthAfter, double congestionReduction
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append("Traffic Optimization Report:\n");
        sb.append("1. Traffic Flow Improvement:\n");
        sb.append("   - Average Travel Time Before: ").append(String.format("%.2f", averageTravelTimeBefore)).append(" seconds\n");
        sb.append("   - Average Travel Time After: ").append(String.format("%.2f", averageTravelTimeAfter)).append(" seconds\n");
        sb.append("   - Flow Improvement: ").append(String.format("%.2f", trafficFlowImprovement)).append("%\n");

        sb.append("2. Average Wait Time:\n");
        sb.append("   - Average Wait Time Before: ").append(String.format("%.2f", averageWaitTimeBefore)).append(" seconds\n");
        sb.append("   - Average Wait Time After: ").append(String.format("%.2f", averageWaitTimeAfter)).append(" seconds\n");
        sb.append("   - Wait Time Reduction: ").append(String.format("%.2f", waitTimeReduction)).append("%\n");

        sb.append("3. Overall Congestion Reduction:\n");
        sb.append("   - Average Queue Length Before: ").append(String.format("%.2f", queueLengthBefore)).append(" vehicles\n");
        sb.append("   - Average Queue Length After: ").append(String.format("%.2f", queueLengthAfter)).append(" vehicles\n");
        sb.append("   - Queue Length Reduction: ").append(String.format("%.2f", congestionReduction)).append("%\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
