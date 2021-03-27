package com.cursor.krasulia.hw3.task1;

import com.cursor.krasulia.hw3.task1.abstractShape.Shape;
import com.cursor.krasulia.hw3.task1.vertices.Vertex2D;
import com.cursor.krasulia.hw3.task1.vertices.Vertex3D;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Vertex2D first2DVertex = new Vertex2D(7, 15);
        Vertex2D second2DVertex = new Vertex2D(3, 6);
        Vertex2D third2DVertex = new Vertex2D(4, 7);

        Vertex3D first3DVertex = new Vertex3D(2, 5, 7);

        Shape[] shapes = new Shape[6];
        shapes[0] = new Triangle(first2DVertex, second2DVertex, third2DVertex);
        shapes[1] = new Rectangle(first2DVertex, 3, 7);
        shapes[2] = new Circle(first2DVertex, 6);
        shapes[3] = new SquarePyramid(first3DVertex, 6, 8);
        shapes[4] = new Cuboid(first3DVertex, 6, 8, 9);
        shapes[5] = new Sphere(first3DVertex, 6);

//        System.out.println(Arrays.toString(shapes));
        Arrays.stream(shapes).forEach(System.out::println);
    }
}
