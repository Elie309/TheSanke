package com.elie309.thesnake.Utils;


public abstract class Entity {

    private PVector location;
    private PVector velocity;

    protected abstract void update();

    protected abstract void display();


    public PVector getLocation() {
        return location;
    }

    public void setLocation(PVector location) {
        this.location = location;
    }

    public PVector getVelocity() {
        return velocity;
    }

    public void setVelocity(PVector velocity) {
        this.velocity = velocity;
    }



}
