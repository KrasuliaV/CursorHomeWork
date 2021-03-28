package com.cursor.krasulia.hw3.task1.abstract_shape;

import com.cursor.krasulia.hw3.task1.measurable.AreaMeasurable;
import com.cursor.krasulia.hw3.task1.measurable.VolumeMeasurable;
import com.cursor.krasulia.hw3.task1.vertices.Vertex3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SpaceShape extends Shape implements AreaMeasurable, VolumeMeasurable {
    List<Vertex3D> verticesList;

    public SpaceShape(Vertex3D... vertices) {
        verticesList = new ArrayList<>();
        verticesList.addAll(Arrays.asList(vertices));
    }

    public List<Vertex3D> getVerticesList() {
        return verticesList;
    }

    @Override
    public String toString() {
        return "Shape type: " + getClass().getSimpleName().toLowerCase()
                + ", vertices: " + verticesList.toString()
                + ", area: " + String.format("%.2f", getArea())
                + ", volume: " + String.format("%.2f", getVolume());
    }
}
