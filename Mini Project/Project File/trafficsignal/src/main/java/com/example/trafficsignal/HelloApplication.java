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

        Rectangle trafficLightContainer = new Rectangle(80, 200); // Reduced size
        trafficLightContainer.setArcWidth(20);
        trafficLightContainer.setArcHeight(20);
        trafficLightContainer.setFill(Color.BLACK);
        trafficLightContainer.setStroke(Color.DARKGRAY);
        trafficLightContainer.setStrokeWidth(2);

        Rectangle trafficLightStand = new Rectangle(10, 50); // Reduced size
        trafficLightStand.setFill(Color.DARKGRAY);

        // Create the cover for the traffic light
        Rectangle cover = new Rectangle(80, 20); // Cover size
        cover.setFill(Color.GRAY);
        cover.setStroke(Color.BLACK);
        cover.setStrokeWidth(2);
        cover.setArcWidth(10);
        cover.setArcHeight(10);
        
        // Stack the cover on top of the traffic light container
        StackPane trafficLightPane = new StackPane(trafficLightContainer, cover);
        
        VBox lightBox = new VBox(5, redLight, yellowLight, greenLight); // Reduced spacing
        lightBox.setStyle("-fx-alignment: center; -fx-padding: 10;");
        
        Label directionLabel = new Label(direction);
        directionLabel.setStyle("-fx-background-color: lightgray; -fx-padding: 5; -fx-border-color: black; -fx-border-width: 1;");
        
        StackPane trafficLight = new StackPane(trafficLightPane, lightBox);
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

    // Create a traffic light circle with increased size
    private Circle createLight(Paint color) {
        Circle light = new Circle(30); // Adjusted size
        light.setFill(color);
        light.setStroke(Color.BLACK);
        light.setStrokeWidth(2);
        return light;
    }

    // Optimization calculation methods
    private int[] computeGreenTimes(int[] queueLengths, int totalVehicles, double peakHourAdjustmentFactor) {
        int numLanes = queueLengths.length;
        int[] greenTimes = new int[numLanes];
        int totalQueueLength = 0;
        for (int length : queueLengths) {
            totalQueueLength += length;
        }
        for (int i = 0; i < numLanes; i++) {
            greenTimes[i] = (int) ((double) queueLengths[i] / totalQueueLength * (TOTAL_CYCLE_TIME - YELLOW_TIME * numLanes) * peakHourAdjustmentFactor);
        }
        return greenTimes;
    }

    private int[] computeRedTimes(int[] greenTimes) {
        int numLanes = greenTimes.length;
        int[] redTimes = new int[numLanes];
        for (int i = 0; i < numLanes; i++) {
            redTimes[i] = TOTAL_CYCLE_TIME - greenTimes[i] - YELLOW_TIME;
        }
        return redTimes;
    }

    private int computePedestrianTime(int pedestrianDemand) {
        return pedestrianDemand * PEDESTRIAN_TIME_PER_PERSON;
    }

    private int[] adjustGreenTimesForCycleTime(int[] greenTimes, int adjustedCycleTime) {
        int totalGreenTime = 0;
        for (int time : greenTimes) {
            totalGreenTime += time;
        }
        int numLanes = greenTimes.length;
        int[] adjustedGreenTimes = new int[numLanes];
        for (int i = 0; i < numLanes; i++) {
            adjustedGreenTimes[i] = (int) ((double) greenTimes[i] / totalGreenTime * adjustedCycleTime);
        }
        return adjustedGreenTimes;
    }

    private double computeAverageTravelTime(int[] queueLengths, int[] greenTimes) {
        int numLanes = queueLengths.length;
        double totalTravelTime = 0;
        for (int i = 0; i < numLanes; i++) {
            totalTravelTime += (double) queueLengths[i] / greenTimes[i];
        }
        return totalTravelTime / numLanes;
    }

    private double computeTrafficFlowImprovement(double averageTravelTimeBefore, double averageTravelTimeAfter) {
        return averageTravelTimeBefore - averageTravelTimeAfter;
    }

    private double computeAverageWaitTime(int[] queueLengths, int[] greenTimes) {
        int numLanes = queueLengths.length;
        double totalWaitTime = 0;
        for (int i = 0; i < numLanes; i++) {
            totalWaitTime += (double) queueLengths[i] / greenTimes[i];
        }
        return totalWaitTime / numLanes;
    }

    private double computeWaitTimeReduction(double averageWaitTimeBefore, double averageWaitTimeAfter) {
        return averageWaitTimeBefore - averageWaitTimeAfter;
    }

    private double computeTotalQueueLength(int[] greenTimes) {
        double totalQueueLength = 0;
        for (int time : greenTimes) {
            totalQueueLength += time;
        }
        return totalQueueLength;
    }

    private double computeCongestionReduction(double queueLengthBefore, double queueLengthAfter) {
        return queueLengthBefore - queueLengthAfter;
    }

    private String generateTimingsText(int[] greenTimes, int[] redTimes) {
        StringBuilder sb = new StringBuilder("Optimized Timings:\n");
        for (int i = 0; i < greenTimes.length; i++) {
            sb.append("Intersection ").append(i + 1).append(" - Green: ").append(greenTimes[i]).append("s, Yellow: 5s, Red: ").append(redTimes[i]).append("s\n");
        }
        return sb.toString();
    }

    private String generateMetricsText(double avgTravelBefore, double avgTravelAfter, double flowImprovement,
                                       double avgWaitBefore, double avgWaitAfter, double waitReduction,
                                       double queueBefore, double queueAfter, double congestionReduction) {
        return String.format(
            "Optimized Traffic Report: \nAverage Travel Time Before: %.2f\n" +
            "Average Travel Time After: %.2f\n" +
            "Traffic Flow Improvement: %.2f\n" +
            "Average Wait Time Before: %.2f\n" +
            "Average Wait Time After: %.2f\n" +
            "Wait Time Reduction: %.2f\n" +
            "Total Queue Length Before: %.2f\n" +
            "Total Queue Length After: %.2f\n" +
            "Congestion Reduction: %.2f",
            avgTravelBefore, avgTravelAfter, flowImprovement,
            avgWaitBefore, avgWaitAfter, waitReduction,
            queueBefore, queueAfter, congestionReduction
        );
    }

    public static void main(String[] args) {
        launch();
    }
}
