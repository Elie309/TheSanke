package com.elie309.thesnake.GameEntities;

import com.elie309.thesnake.GamePlanner;
import com.elie309.thesnake.Main;
import com.elie309.thesnake.Utils.Entity;
import com.elie309.thesnake.Utils.PVector;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.Deque;
import java.util.LinkedList;

public class SnakePlayer extends Entity {


    private final Canvas canvas = GamePlanner.canvas;
    private final GraphicsContext gc = GamePlanner.gc;

    private final float WIDTH = (float) this.canvas.getWidth();
    private final float HEIGHT = (float) this.canvas.getHeight();

    public int snakeSize = 10;

    public static int tailSize = 3;
    public static Deque<PVector> snakeBodyPosition = new LinkedList<>();

    public PVector snakeHead;

    public SnakePlayer(PVector location, PVector velocity) {
        setLocation(location);
        setVelocity(velocity);

        snakeBodyPosition.push(new PVector(this.getLocation().getX(), this.getLocation().getY()));
        this.snakeHead = snakeBodyPosition.peek();

        Scene gameScene = Main.gameScene;
        gameScene.setOnKeyPressed(SnakeKeyHandler());
    }

    private EventHandler<? super KeyEvent> SnakeKeyHandler() {

        return event -> {
            switch (event.getCode()) {

                case UP:
                    if( this.snakeHead.getY() < 0 ){
                        this.snakeHead.setVector(new PVector(
                                this.snakeHead.getX(),
                                HEIGHT - 10)
                        );
                    }
                    this.move(0, -1);

                    break;
                case DOWN:
                    if( this.snakeHead.getY() > HEIGHT - 10){
                        this.snakeHead.setVector(new PVector(this.snakeHead.getX(), 0));
                    }
                    this.move(0, 1);
                    break;

                case LEFT:
                    if( this.snakeHead.getX() < 0){
                        this.snakeHead.setVector(
                                new PVector(
                                        WIDTH - 8,
                                        this.snakeHead.getY())
                        );
                    }

                    this.move(-1, 0);
                    break;
                case RIGHT:
                    if( this.snakeHead.getX() > WIDTH - 15){
                        this.snakeHead.setVector(new PVector(0,this.snakeHead.getY()));
                    }

                    this.move(1, 0);
                    break;
                default:
                    break;
            }
        };
    }

    @Override
    public void update() {

        Deque<PVector> temp = new LinkedList<>();
        for(PVector vector : snakeBodyPosition){
            temp.add(vector);

            if(this.snakeHead.equals(vector)) continue;

            if(PVector.intersect(this.snakeHead, vector)){
                tailSize = Math.max(temp.size(), 3);
                snakeBodyPosition.clear();
                snakeBodyPosition.addAll(temp);
                break;
            }
        }


        display();
    }

    @Override
    public void display() {
        gc.setFill(Color.GREEN);
        for(PVector vector : snakeBodyPosition){
            gc.fillRect(vector.getX(), vector.getY(), snakeSize, snakeSize);
        }

    }

    public void move(int x, int y) {

        try {

            PVector velocityClone = getVelocity().clone();

            if(snakeBodyPosition.size() < tailSize){
                snakeBodyPosition.push(this.snakeHead.clone());
            }else if(snakeBodyPosition.size() == tailSize){
              snakeBodyPosition.removeLast();
            }

            if (x == 0 && y != 0) {
                velocityClone.setX(0);
                velocityClone.multiY(y);

                this.snakeHead.add(velocityClone);
                return;
            }
            if (x != 0 && y == 0) {
                velocityClone.setY(0);
                velocityClone.multiX(x);
                this.snakeHead.add(velocityClone);
                return;
            }
            if (x != 0) { //  y != 0 is redundant since it will always be true
                velocityClone.multiY(y);
                velocityClone.multiX(x);
                this.snakeHead.add(velocityClone);
            }

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }


}
