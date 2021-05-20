package com.cursor.krasulia.hw16;


import com.cursor.krasulia.hw16.entity.Robot;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.cursor.krasulia.hw16"})
public class Tess {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Tess.class);

        Robot robot = context.getBean("robot", Robot.class);
        robot.getLegs().robotMove();
        robot.getBody().robotSpin();
        robot.getLeftHand().robotPush();
        robot.getRightHand().robotPush();
        robot.getHead().robotThink();

    }
}

