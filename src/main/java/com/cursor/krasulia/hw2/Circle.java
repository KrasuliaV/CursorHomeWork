package com.cursor.krasulia.hw2;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double square() {
        return Math.PI * Math.pow(radius, 2);
    }
}
