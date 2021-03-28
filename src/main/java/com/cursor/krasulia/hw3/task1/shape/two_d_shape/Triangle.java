package com.cursor.krasulia.hw3.task1.shape.two_d_shape;

import com.cursor.krasulia.hw3.task1.abstract_shape.PlaneShape;
import com.cursor.krasulia.hw3.task1.vertices.Vertex2D;

import static com.cursor.krasulia.hw3.task1.vertices.Vertex2D.getDistanceBetweenTwo2DVertices;

public class Triangle extends PlaneShape {
    private final double firstSide;
    private final double secondSide;
    private final double thirdSide;

    public Triangle(Vertex2D firstVertex, Vertex2D secondVertex, Vertex2D thirdVertex) {
        super(firstVertex, secondVertex, thirdVertex);
        this.firstSide = getDistanceBetweenTwo2DVertices(getVerticesList().get(0), getVerticesList().get(1));
        this.secondSide = getDistanceBetweenTwo2DVertices(getVerticesList().get(0), getVerticesList().get(1));
        this.thirdSide = getDistanceBetweenTwo2DVertices(getVerticesList().get(0), getVerticesList().get(1));
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide));
    }

    @Override
    public double getPerimeter() {
        return firstSide + secondSide + thirdSide;
    }

    public double getFirstSide() {
        return firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }

}
