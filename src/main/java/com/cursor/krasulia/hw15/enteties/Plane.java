package com.cursor.krasulia.hw15.enteties;

import lombok.Data;

@Data
public class Plane extends AbstractEntity {
    private String model;
    private String serialNumber;
    private int seats;
}
