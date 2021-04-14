package com.cursor.krasulia.hw8.task1.exception;

public class ExceptionA extends Exception {

    public ExceptionA() {
    }

    public ExceptionA(String message) {
        super("Exception from constructor ExceptionA: " + message);
    }
}
