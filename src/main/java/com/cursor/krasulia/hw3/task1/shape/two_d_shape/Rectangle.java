package com.cursor.krasulia.hw3.task1.shape.two_d_shape;

import com.cursor.krasulia.hw3.task1.abstract_shape.PlaneShape;
import com.cursor.krasulia.hw3.task1.vertices.Vertex2D;

public class Rectangle extends PlaneShape {
    private final int width;
    private final int height;

    public Rectangle(Vertex2D vertex, int width, int height) {
        super(vertex);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

}
