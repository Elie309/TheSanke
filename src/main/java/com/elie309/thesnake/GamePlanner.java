package com.elie309.thesnake;


import com.elie309.thesnake.GameEntities.Apple;
import com.elie309.thesnake.GameEntities.SnakePlayer;
import com.elie309.thesnake.Utils.PVector;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GamePlanner implements Runnable{

    public static Canvas canvas = new Canvas();
    public static GraphicsContext gc = canvas.getGraphicsContext2D();

    private final float WIDTH;
    private final float HEIGHT;


    //Game Objects

    private SnakePlayer snakePlayer;
    private Apple apple;


    public GamePlanner(float width, float height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        initialization();
    }


    public void initialization(){

        this.snakePlayer = new SnakePlayer(
                new PVector(WIDTH/2, HEIGHT/2),
                new PVector(3,3)
        );

        this.apple = new Apple( WIDTH,HEIGHT);


        draw();
    }

    public void draw(){
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        this.snakePlayer.update();
        this.apple.update();

    }

    @Override
    public void run() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                draw();
            }
        };
        animationTimer.start();
    }

    //#endregion

}
