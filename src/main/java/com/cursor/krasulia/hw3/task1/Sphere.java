package com.cursor.krasulia.hw3.task1;

import com.cursor.krasulia.hw3.task1.abstractShape.SpaceShape;
import com.cursor.krasulia.hw3.task1.vertices.Vertex3D;

public class Sphere extends SpaceShape {

    private final int radius;

    public Sphere(Vertex3D vertex, int radius) {
        super(vertex);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }
}
