package com.example.trafficsignal;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {

    // Constants for traffic signal optimization
    private static final int TOTAL_CYCLE_TIME = 120; // Total cycle time in seconds
    private static final int YELLOW_TIME = 5;       // Standard yellow time in seconds
    private static final int PEDESTRIAN_TIME_PER_PERSON = 3; // Time per pedestrian in seconds

    @Override
    public void start(Stage primaryStage) {
        // Create four sets of traffic lights with directional names
        VBox[] trafficLights = new VBox[4];
        String[] directions = {"Northbound", "Southbound", "Eastbound", "Westbound"};
        for (int i = 0; i < 4; i++) {
            trafficLights[i] = createTrafficLight(directions[i]);
        }

        // Arrange the four sets of traffic lights side by side in an HBox
        HBox trafficLightsBox = new HBox(20, trafficLights);
        trafficLightsBox.setStyle("-fx-alignment: center; -fx-padding: 20;");

        // Create labels for optimization metrics
        Label timingsLabel = new Label();
        timingsLabel.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 2; -fx-padding: 10;");
        Label metricsLabel = new Label();
        metricsLabel.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 2; -fx-padding: 10;");

        // Arrange the labels side by side in an HBox
        HBox reportBox = new HBox(20, timingsLabel, metricsLabel);
        reportBox.setStyle("-fx-alignment: center;");

        // Create a bordered container to hold the labels without outer border
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(reportBox);
        borderPane.setStyle("-fx-padding: 10;"); // Remove outer border

        // Create a button to toggle visibility
        Button toggleButton = new Button("Show/Hide Report");
        toggleButton.setOnAction(e -> borderPane.setVisible(!borderPane.isVisible()));

        // Arrange the traffic light, button, and bordered container in a VBox
        VBox root = new VBox(20, trafficLightsBox, toggleButton, borderPane);
        root.setStyle("-fx-alignment: center; -fx-padding: 20; -fx-border-color: black; -fx-border-width: 3; -fx-background-color: white;");

        // Create the scene and set the stage
        Scene scene = new Scene(root, 800, 600); // Increased width to accommodate side by side labels
        primaryStage.setTitle("Traffic Signal Animation and Optimization");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Example input data for optimization
        int[] queueLengths = {150, 120, 200, 180}; // Queue lengths for Northbound, Southbound, Eastbound, Westbound
        int totalVehicles = 650; // Total number of vehicles across all lanes
        double peakHourAdjustmentFactor = 1.2; // Adjust for peak hours (1.2 for peak hours, 1.0 otherwise)
        int pedestrianDemand = 10; // Number of pedestrians waiting to cross

        // Compute optimized timings for each lane
        int[] greenTimes = computeGreenTimes(queueLengths, totalVehicles, peakHourAdjustmentFactor);
        int[] redTimes = computeRedTimes(greenTimes);
        int pedestrianTime = computePedestrianTime(pedestrianDemand);

        // Adjust for pedestrian crossing
        int adjustedCycleTime = TOTAL_CYCLE_TIME - pedestrianTime;
        int[] adjustedGreenTimes = adjustGreenTimesForCycleTime(greenTimes, adjustedCycleTime);

        // Metrics calculations
        double averageTravelTimeBefore = computeAverageTravelTime(queueLengths, greenTimes);
        double averageTravelTimeAfter = computeAverageTravelTime(queueLengths, adjustedGreenTimes);
        double trafficFlowImprovement = computeTrafficFlowImprovement(averageTravelTimeBefore, averageTravelTimeAfter);
        double averageWaitTimeBefore = computeAverageWaitTime(queueLengths, greenTimes);
        double averageWaitTimeAfter = computeAverageWaitTime(queueLengths, adjustedGreenTimes);
        double waitTimeReduction = computeWaitTimeReduction(averageWaitTimeBefore, averageWaitTimeAfter);
        double queueLengthBefore = totalVehicles;
        double queueLengthAfter = computeTotalQueueLength(adjustedGreenTimes);
        double congestionReduction = computeCongestionReduction(queueLengthBefore, queueLengthAfter);

        // Update labels with results
        timingsLabel.setText(generateTimingsText(adjustedGreenTimes, redTimes));
        metricsLabel.setText(generateMetricsText(
                averageTravelTimeBefore, averageTravelTimeAfter,
                trafficFlowImprovement, averageWaitTimeBefore, averageWaitTimeAfter,
                waitTimeReduction, queueLengthBefore, queueLengthAfter, congestionReduction
        ));

        // Create a timeline for the animation
        Timeline timeline = new Timeline();
        int currentTime = 0;
        for (int i = 0; i < 4; i++) {
            int index = i;
            // Initial state: All lights red
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(currentTime), e -> {
                setTrafficLightState(trafficLights[index], false, false, true); // Set green for current lane
                for (int j = 0; j < 4; j++) {
                    if (j != index) {
                        setTrafficLightState(trafficLights[j], true, false, false); // Set red for other lanes
                    }
                }
            }));
            currentTime += adjustedGreenTimes[i];
            // Yellow light on after green
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(currentTime), e -> {
                setTrafficLightState(trafficLights[index], false, true, false);
            }));
            currentTime += YELLOW_TIME;
        }
        // Red light on after yellow
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(currentTime), e -> {
            for (VBox light : trafficLights) {
                setTrafficLightState(light, true, false, false);
            }
        }));

        // Set the cycle count to indefinite to keep the animation running
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    // Create a traffic light VBox with directional name
    private VBox createTrafficLight(String direction) {
        
        Circle redLight = createLight(Color.RED);
        Circle yellowLight = createLight(Color.GRAY);
        Circle greenLight = createLight(Color.GRAY);

        Rectangle trafficLightContainer = new Rectangle(150, 400);
        trafficLightContainer.setArcWidth(50);
        trafficLightContainer.setArcHeight(50);
        trafficLightContainer.setFill(Color.BLACK);

        Rectangle trafficLightStand = new Rectangle(20, 100);
        trafficLightStand.setFill(Color.DARKGRAY);

        VBox lightBox = new VBox(10, redLight, yellowLight, greenLight);
        lightBox.setStyle("-fx-alignment: center; -fx-padding: 20;");

        Label directionLabel = new Label(direction);
        directionLabel.setStyle("-fx-background-color: lightgray; -fx-padding: 5; -fx-border-color: black; -fx-border-width: 1;");

        StackPane trafficLight = new StackPane(trafficLightContainer, lightBox);
        VBox trafficLightWithStand = new VBox(directionLabel, trafficLight, trafficLightStand);
        trafficLightWithStand.setStyle("-fx-alignment: center;");
        return trafficLightWithStand;
    }

    // Set the state of a traffic light
    private void setTrafficLightState(VBox trafficLight, boolean redOn, boolean yellowOn, boolean greenOn) {
        Circle redLight = (Circle) ((VBox)((StackPane) trafficLight.getChildren().get(1)).getChildren().get(1)).getChildren().get(0);
        Circle yellowLight = (Circle) ((VBox)((StackPane) trafficLight.getChildren().get(1)).getChildren().get(1)).getChildren().get(1);
        Circle greenLight = (Circle) ((VBox)((StackPane) trafficLight.getChildren().get(1)).getChildren().get(1)).getChildren().get(2);
        redLight.setFill(redOn ? Color.RED : Color.GRAY);
        yellowLight.setFill(yellowOn ? Color.YELLOW : Color.GRAY);
        greenLight.setFill(greenOn ? Color.GREEN : Color.GRAY);
    }

    // Create a traffic light circle
    private Circle createLight(Paint color) {
        Circle light = new Circle(50, color);
        light.setStroke(Color.BLACK);
        light.setStrokeWidth(2);
        return light;
    }

    // Compute green times for each lane
    public static int[] computeGreenTimes(int[] queueLengths, int totalVehicles, double peakHourAdjustmentFactor) {
        int[] greenTimes = new int[queueLengths.length];
        int totalQueueLength = 0;
        for (int length : queueLengths) {
            totalQueueLength += length;
        }

        // Adjust total cycle time based on peak hour factor
        int adjustedCycleTime = (int) (TOTAL_CYCLE_TIME * peakHourAdjustmentFactor);

        for (int i = 0; i < queueLengths.length; i++) {
            greenTimes[i] = (int) (((double) queueLengths[i] / totalQueueLength) * (adjustedCycleTime - YELLOW_TIME * queueLengths.length));
        }

        return greenTimes;
    }

    // Compute red times for each lane
    public static int[] computeRedTimes(int[] greenTimes) {
        int[] redTimes = new int[greenTimes.length];
        for (int i = 0; i < greenTimes.length; i++) {
            redTimes[i] = TOTAL_CYCLE_TIME - greenTimes[i] - YELLOW_TIME;
        }
        return redTimes;
    }

    // Compute pedestrian time
    public static int computePedestrianTime(int pedestrianDemand) {
        return pedestrianDemand * PEDESTRIAN_TIME_PER_PERSON;
    }

    // Adjust green times to fit within the adjusted cycle time
    public static int[] adjustGreenTimesForCycleTime(int[] greenTimes, int adjustedCycleTime) {
        int totalGreenTime = 0;
        for (int greenTime : greenTimes) {
            totalGreenTime += greenTime;
        }

        int[] adjustedGreenTimes = new int[greenTimes.length];
        for (int i = 0; i < greenTimes.length; i++) {
            adjustedGreenTimes[i] = (int) ((greenTimes[i] / (double) totalGreenTime) * adjustedCycleTime);
        }
        return adjustedGreenTimes;
    }

    // Compute average travel time for vehicles before optimization
    public static double computeAverageTravelTime(int[] queueLengths, int[] greenTimes) {
        double totalTravelTime = 0;
        for (int i = 0; i < queueLengths.length; i++) {
            totalTravelTime += queueLengths[i] / (double) greenTimes[i];
        }
        return totalTravelTime / queueLengths.length;
    }

    // Compute traffic flow improvement
    public static double computeTrafficFlowImprovement(double averageTravelTimeBefore, double averageTravelTimeAfter) {
        return ((averageTravelTimeBefore - averageTravelTimeAfter) / averageTravelTimeBefore) * 100;
    }

    // Compute average wait time for vehicles before optimization
    public static double computeAverageWaitTime(int[] queueLengths, int[] greenTimes) {
        double totalWaitTime = 0;
        for (int i = 0; i < queueLengths.length; i++) {
            totalWaitTime += queueLengths[i] * greenTimes[i];
        }
        return totalWaitTime / queueLengths.length;
    }

    // Compute wait time reduction
    public static double computeWaitTimeReduction(double averageWaitTimeBefore, double averageWaitTimeAfter) {
        return ((averageWaitTimeBefore - averageWaitTimeAfter) / averageWaitTimeBefore) * 100;
    }

    // Compute total queue length after optimization
    public static double computeTotalQueueLength(int[] greenTimes) {
        double totalQueueLength = 0;
        for (int greenTime : greenTimes) {
            totalQueueLength += greenTime;
        }
        return totalQueueLength;
    }

    // Compute congestion reduction
    public static double computeCongestionReduction(double queueLengthBefore, double queueLengthAfter) {
        return ((queueLengthBefore - queueLengthAfter) / queueLengthBefore) * 100;
    }

    // Generate text for optimized timings for Lane 1 only
    public static String generateTimingsText(int[] adjustedGreenTimes, int[] redTimes) {
        StringBuilder timingsText = new StringBuilder("Intersection 1 Timings:\n");
        timingsText.append(String.format("Green Time = %d s, Yellow Time = %d s, Red Time = %d s\n",
                adjustedGreenTimes[0], YELLOW_TIME, redTimes[0]));
        return timingsText.toString();
    }

    // Generate text for optimization metrics
    public static String generateMetricsText(double averageTravelTimeBefore, double averageTravelTimeAfter,
                                             double trafficFlowImprovement, double averageWaitTimeBefore, double averageWaitTimeAfter,
                                             double waitTimeReduction, double queueLengthBefore, double queueLengthAfter,
                                             double congestionReduction) {
        return String.format(
                        "Optimization Metrics:\n" +
                        "Average Travel Time Before: %.2f s " +
                        "Average Travel Time After: %.2f s " +
                        "Traffic Flow Improvement: %.2f%% " +
                        "Average Wait Time Before: %.2f s " +
                        "Average Wait Time After: %.2f s " +
                        "Wait Time Reduction: %.2f%%\n" +
                        "Total Queue Length Before: %.2f\n" +
                        "Total Queue Length After: %.2f" +
                        "Congestion Reduction: %.2f%%",
                averageTravelTimeBefore, averageTravelTimeAfter, trafficFlowImprovement, averageWaitTimeBefore,
                averageWaitTimeAfter, waitTimeReduction, queueLengthBefore, queueLengthAfter, congestionReduction);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
