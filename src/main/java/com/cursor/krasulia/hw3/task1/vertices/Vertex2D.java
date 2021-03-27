package com.cursor.krasulia.hw3.task1.vertices;

public class Vertex2D extends Vertex {

    int y;

    public Vertex2D(int x, int y) {
        super(x);
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public static double getDistanceBetweenTwo2DVertices(Vertex2D firstVertex, Vertex2D secondVertex) {
        return Math.sqrt(Math.pow(firstVertex.getX() - secondVertex.getX(), 2) + Math.pow(firstVertex.getY() - secondVertex.getY(), 2));
    }

    @Override
    public String toString() {
        return "Vertex2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
