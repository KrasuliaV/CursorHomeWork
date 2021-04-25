package com.cursor.krasulia.hw11.ping_pong;

public class AnswerChecker {
    public static String checkAnswer(String answer) {
        if (answer.matches("[\\d]+")) {
            return answer;
        } else {
            System.out.println("You put not right number. So I will choose myself");
            return "50";
        }
    }
}
