package com.cursor.krasulia.hw8.task2.enums;

public enum TextTemplate {
    CHOOSE_OPERATION("Choose operation:\nWrite 1 for Safe Division\nWrite 2 for Exit"),
    WRONG_INPUT("You write wrong number"),
    WRITE_FIRST("Write first number - only integer!"),
    WRITE_SECOND("Write second number - only integer!"),
    SORRY("Sorry! But you can't divide by zero"),
    GREETINGS("Hello my little friend in my SafeDivisionCalculator!"),
    GOOD_BYE("Bye-Bye, my little friend!\nEnd REMEMBER!!!\nDon't divide by zero!!");

    private String text;

    TextTemplate(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
