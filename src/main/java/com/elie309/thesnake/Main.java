package com.elie309.thesnake;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {

    public static Rectangle2D screenBounds = Screen.getPrimary().getBounds();

    public static Scene gameScene;

    public double HEIGHT = screenBounds.getMaxY()/2 + 150;
    public double WIDTH = screenBounds.getMaxX()/2 +100;

    @Override
    public void start(Stage stage) {

        stage.setTitle("The Snake!");

        stage.setResizable(false);

        Group root = new Group();

         gameScene = new Scene(root, WIDTH, HEIGHT);

        Canvas mainCanvas = GamePlanner.canvas;
        mainCanvas.setWidth(WIDTH);
        mainCanvas.setHeight(HEIGHT);

        GamePlanner planner = new GamePlanner((float)WIDTH, (float)HEIGHT);
        Thread thread = new Thread(planner);

        root.getChildren().add(mainCanvas);

        stage.setScene(gameScene);
        stage.show();

        thread.start();

    }

    public static void main(String[] args) {
        launch();
    }
}