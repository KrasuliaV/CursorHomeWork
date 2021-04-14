package com.cursor.krasulia.hw8.task1.exception;

public class ExceptionB extends ExceptionA {

    public ExceptionB() {
    }

    public ExceptionB(String message) {
        super("Exception from constructor ExceptionB: " + message);
    }
}
