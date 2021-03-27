package com.cursor.krasulia.hw3.task1;

import com.cursor.krasulia.hw3.task1.abstractShape.PlaneShape;
import com.cursor.krasulia.hw3.task1.vertices.Vertex2D;

public class Circle extends PlaneShape {
    private final int radius;

    public Circle(Vertex2D vertex, int radius) {
        super(vertex);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
