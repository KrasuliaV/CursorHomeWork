package com.cursor.krasulia.hw2.task3;

public class SpyCar extends Car {
    private boolean isVisible = true;


    public SpyCar(int maxSpeed) {
        super(maxSpeed);
    }

    public void turnOnInvisible() {
        isVisible = false;
        System.out.println("Your spy-car is invisible");
    }

    public void turnOffInvisible() {
        isVisible = false;
        System.out.println("Your car is visible");
    }

    public void fire() {
        System.out.println("Tra-ta-ta-ta");
        System.out.println("Your enemies are dead");
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Spy engine is very quite");
    }

}
