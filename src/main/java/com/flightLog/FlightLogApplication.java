package com.flightLog;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class FlightLogApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(FlightLogApplication.class.getResource("FlightLogView.fxml"));
        Scene scene = new Scene(root.load(), 881, 973);
        String css = Objects.requireNonNull(this.getClass().getResource("mainCSS.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Flight Log Application");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(new Image(String.valueOf(this.getClass().getResource("/images/9112478_fighter_jet_solid_icon.png"))));

        stage.setScene(scene);
        stage.show();
    }

    private static double xOffset = 0;
    private static double yOffset = 0;
    public static void main(String[] args) {
        launch();
    }

    public static Pane titlePane(final Stage primaryStage) {
        Pane bp = new Pane();
        bp.setPrefSize(900, 500);
        bp.setMaxSize(900, 500);
        bp.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        bp.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        return bp;

    }
}