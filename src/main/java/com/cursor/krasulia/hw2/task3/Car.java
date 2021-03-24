package com.cursor.krasulia.hw2.task3;

public class Car {
    private boolean engineIsWorking = false;
    private boolean carIsMoving = false;
    private int maxSpeed = 200;

    public Car() {
    }

    public Car(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void startEngine() {
        engineIsWorking = true;
        System.out.println("The engine is starting to work");
    }

    public void shutsDownTheEngine() {
        if (carIsMoving) carIsMoving = false;
        engineIsWorking = false;
        System.out.println("The engine is shutting down");
    }

    public void startMove() {
        move(maxSpeed);
    }

    public void startMove(int moveSpeed) {
        move(moveSpeed);
    }

    private void move(int moveSpeed) {
        if (engineIsWorking) {
            carIsMoving = true;
            System.out.println("The car starts moving");
            for (int i = 1; i <= moveSpeed; i++) {
                System.out.print(i + " km/h...");
            }
            System.out.println("\nCar is moving with speed: " + maxSpeed + " km/h");
        } else {
            System.out.println("You must start engine at first");
        }
    }
}
