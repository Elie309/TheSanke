package com.elie309.thesnake.GameEntities;

import com.elie309.thesnake.GamePlanner;
import com.elie309.thesnake.Utils.Entity;
import com.elie309.thesnake.Utils.PVector;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Deque;

public class Apple extends Entity {


    public static GraphicsContext gc = GamePlanner.gc;

    public Deque<PVector> snakeBodyPosition = SnakePlayer.snakeBodyPosition;

    public static PVector applePosition;

    public final int appleSize = 10;

    private final float widthRange;
    private final float heightRange;

    public Apple(float widthRange, float heightRange) {
        this.widthRange = widthRange;
        this.heightRange = heightRange;
        applePosition = PVector.generateRandomVector(widthRange, heightRange);
    }

    public void generateAppleRandomly(){
        applePosition = PVector.generateRandomVector(widthRange, heightRange);
    }


    @Override
    public void update() {
        assert snakeBodyPosition.peek() != null;
        if(PVector.intersect(snakeBodyPosition.peek(), 3, applePosition, 3)){
            SnakePlayer.tailSize += 5;
            generateAppleRandomly();
        }
        display();
    }

    @Override
    public void display() {
        gc.setFill(Color.RED);
        gc.fillRect(applePosition.getX(), applePosition.getY(), appleSize,appleSize);

    }
}
