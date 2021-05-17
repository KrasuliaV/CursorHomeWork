package com.cursor.krasulia.hw15.enteties;

import lombok.Data;

import java.util.List;

@Data
public class Pilot extends AbstractEntity {
    private String name;
    private int age;
    private List<Plane> planeList;
}
