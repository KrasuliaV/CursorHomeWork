package com.cursor.krasulia.hw8.task2;

import com.cursor.krasulia.hw8.task2.enums.Status;

import java.util.Scanner;

import static com.cursor.krasulia.hw8.task2.enums.Status.*;
import static com.cursor.krasulia.hw8.task2.enums.TextTemplate.*;

public class SafeDivision {

    private static final Scanner sc = new Scanner(System.in);

    private static Status status;

    private static int firstNumber;

    public static void startSafeDivision() {
        System.out.println(GREETINGS.getText());
        status = CHOSE_OPERATION;
        applicationWork();
        System.out.println(GOOD_BYE.getText());
    }

    private static void applicationWork() {
        while (status != EXIT) {
            if (status.equals(CHOSE_OPERATION)) {
                System.out.println(CHOOSE_OPERATION.getText());
                checkAnswerForChoseOperation(sc.next());
            } else if (status.equals(WRITE_FIRST_NUMBER)) {
                System.out.println(WRITE_FIRST.getText());
                checkFirstNumberForDivision(sc.next());
            } else if (status.equals(WRITE_SECOND_NUMBER)) {
                System.out.println(WRITE_SECOND.getText());
                checkSecondNumberForDivision(sc.next());
            }
        }
    }

    private static void checkAnswerForChoseOperation(String answer) {
        if (answer.equals("1")) {
            status = WRITE_FIRST_NUMBER;
        } else if (answer.equals("2")) {
            status = EXIT;
        } else {
            System.out.println(WRONG_INPUT.getText());
        }
    }

    private static void checkFirstNumberForDivision(String answer) {
        if (answer.matches("[\\d]+")) {
            if (checkForMaxMin(Long.parseLong(answer))) {
                System.out.println(WRONG_INPUT.getText());
            } else {
                firstNumber = Integer.parseInt(answer);
                status = WRITE_SECOND_NUMBER;
            }
        } else {
            System.out.println(WRONG_INPUT.getText());
        }
    }

    private static void checkSecondNumberForDivision(String answer) {
        if (answer.matches("[\\d]+")) {
            if (answer.equals("0")) {
                System.out.println(SORRY.getText());
            } else if (checkForMaxMin(Long.parseLong(answer))) {
                System.out.println(WRONG_INPUT.getText());
            } else {
                System.out.printf("Result of division is: %.2f\n", makeDivision(answer));
                status = CHOSE_OPERATION;
            }
        } else {
            System.out.println(WRONG_INPUT);
        }
    }

    private static boolean checkForMaxMin(long someNumber) {
        return someNumber > Integer.MAX_VALUE || someNumber < Integer.MIN_VALUE;
    }

    private static double makeDivision(String secondNumber) {
        return (double) firstNumber / Integer.parseInt(secondNumber);
    }
}
