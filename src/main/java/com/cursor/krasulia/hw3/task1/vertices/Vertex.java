package com.cursor.krasulia.hw3.task1.vertices;

public class Vertex {
    int x;

    public Vertex(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "x=" + x +
                '}';
    }
}
