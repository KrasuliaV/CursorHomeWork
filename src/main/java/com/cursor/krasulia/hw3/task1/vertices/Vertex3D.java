package com.cursor.krasulia.hw3.task1.vertices;

public class Vertex3D extends Vertex2D {
    int z;

    public Vertex3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Vertex3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
