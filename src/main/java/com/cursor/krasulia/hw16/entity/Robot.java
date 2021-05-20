package com.cursor.krasulia.hw16.entity;

import com.cursor.krasulia.hw16.entity.robot_component.Body;
import com.cursor.krasulia.hw16.entity.robot_component.Hand;
import com.cursor.krasulia.hw16.entity.robot_component.Head;
import com.cursor.krasulia.hw16.entity.robot_component.Legs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Robot {
    Body body;
    Head head;
    Hand leftHand;
    Hand rightHand;
    Legs legs;

    @Autowired
    public Robot(Body body, Head head, Hand leftHand, Hand rightHand, Legs legs) {
        System.out.println("Robot creating");
        this.body = body;
        this.head = head;
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.legs = legs;
        System.out.println("Robot created");
    }

    public Body getBody() {
        return body;
    }

    public Head getHead() {
        return head;
    }

    public Hand getLeftHand() {
        return leftHand;
    }

    public Hand getRightHand() {
        return rightHand;
    }

    public Legs getLegs() {
        return legs;
    }
}
