package com.cursor.krasulia.hw3.task1.abstract_shape;

import com.cursor.krasulia.hw3.task1.measurable.AreaMeasurable;
import com.cursor.krasulia.hw3.task1.measurable.PerimeterMeasurable;
import com.cursor.krasulia.hw3.task1.vertices.Vertex2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class PlaneShape extends Shape implements PerimeterMeasurable, AreaMeasurable {
    List<Vertex2D> verticesList;

    public PlaneShape(Vertex2D... vertices) {
        verticesList = new ArrayList<>();
        verticesList.addAll(Arrays.asList(vertices));
    }

    public List<Vertex2D> getVerticesList() {
        return verticesList;
    }

    @Override
    public String toString() {
        return "Shape type: " + getClass().getSimpleName().toLowerCase()
                + ", vertices: " + verticesList.toString()
                + ", area: " + String.format("%.2f", getArea())
                + ", perimeter: " + String.format("%.2f", getPerimeter());
    }
}
