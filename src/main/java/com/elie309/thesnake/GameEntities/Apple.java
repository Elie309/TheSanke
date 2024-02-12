package com.elie309.thesnake.GameEntities;

import com.elie309.thesnake.GamePlanner;
import com.elie309.thesnake.Main;
import com.elie309.thesnake.Utils.Entity;
import com.elie309.thesnake.Utils.PVector;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Deque;
import java.util.Objects;

public class Apple extends Entity {


    public static GraphicsContext gc = GamePlanner.gc;

    public Deque<PVector> snakeBodyPosition = SnakePlayer.snakeBodyPosition;

    public static PVector applePosition;

    public final int appleSize = 15;

    private final float widthRange;
    private final float heightRange;

    public Apple(float widthRange, float heightRange) {
        this.widthRange = widthRange;
        this.heightRange = heightRange;
        applePosition = PVector.generateRandomVector(widthRange, heightRange);
    }

    public Image getImage(){

        return new Image(
                Objects.requireNonNull(Main.class.getResourceAsStream("entities/apple.png")),
                appleSize,
                appleSize,
                false, false
        );
    }

    public void generateAppleRandomly(){
        applePosition = PVector.generateRandomVector(widthRange, heightRange);
    }


    @Override
    public void update() {
        assert snakeBodyPosition.peek() != null;
        if(PVector.intersect(snakeBodyPosition.peek(), 10, applePosition, 10)){
            SnakePlayer.tailSize += 3;
            generateAppleRandomly();
        }
        display();
    }

    @Override
    public void display() {
        gc.drawImage(getImage(), applePosition.getX(), applePosition.getY());
    }
}
