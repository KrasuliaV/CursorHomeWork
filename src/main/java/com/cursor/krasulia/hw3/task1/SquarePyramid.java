package com.cursor.krasulia.hw3.task1;

import com.cursor.krasulia.hw3.task1.abstractShape.SpaceShape;
import com.cursor.krasulia.hw3.task1.vertices.Vertex3D;

public class SquarePyramid extends SpaceShape {

    private final int width;
    private final int height;

    public SquarePyramid(Vertex3D vertex, int width, int height) {
        super(vertex);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
//        double squareBase = Math.pow(width, 2);
        double apothem = Math.sqrt(Math.pow(height, 2) + Math.pow(width / 2, 2));
//        double squareOneSide = (width * apothem) / 2;
//        return squareBase + 4 * squareOneSide;
        return Math.pow(width, 2) + 2 * (width * apothem);
    }

    @Override
    public double getVolume() {
        return (Math.pow(width, 2) * height) / 3;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
