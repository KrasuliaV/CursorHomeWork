package com.cursor.krasulia.hw16.entity.robot_component;

import org.springframework.stereotype.Component;

@Component
public class Body {

    public Body() {
        System.out.println("Body created");
    }

    public void robotSpin() {
        System.out.println("Robot spinning");
    }
}
