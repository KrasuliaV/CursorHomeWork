package com.cursor.krasulia.hw3.task1.shape.two_d_shape;

import com.cursor.krasulia.hw3.task1.abstract_shape.PlaneShape;
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
