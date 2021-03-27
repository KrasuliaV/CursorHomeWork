package com.cursor.krasulia.hw3.task1;

import com.cursor.krasulia.hw3.task1.abstractShape.SpaceShape;
import com.cursor.krasulia.hw3.task1.vertices.Vertex3D;

public class Cuboid extends SpaceShape {

    private final int width;
    private final int height;
    private final int depth;

    public Cuboid(Vertex3D vertex, int width, int height, int depth) {
        super(vertex);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public double getArea() {
        return 2 * (width * height + width * depth + height * depth);
    }

    @Override
    public double getVolume() {
        return width * height * depth;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

}
