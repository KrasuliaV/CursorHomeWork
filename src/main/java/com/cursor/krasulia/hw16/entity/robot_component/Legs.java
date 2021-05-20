package com.cursor.krasulia.hw16.entity.robot_component;

import org.springframework.stereotype.Component;

@Component
public class Legs {

    public Legs() {
        System.out.println("Legs created");
    }

    public void robotMove() {
        System.out.println("Robot moving");
    }

}
