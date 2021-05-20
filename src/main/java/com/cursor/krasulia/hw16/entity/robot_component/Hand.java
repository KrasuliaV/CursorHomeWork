package com.cursor.krasulia.hw16.entity.robot_component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Hand {

    public Hand() {
        System.out.println("Hands created");
    }

    public void robotPush() {
        System.out.println("Robot " + this.getClass().getSimpleName() + " pushing");
    }
}
