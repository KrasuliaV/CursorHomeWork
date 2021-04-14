package com.cursor.krasulia.hw8.task3;

public class Test {
    public static void someMethod2() throws Exception {
        System.out.println("Вах-Вах)) А звідки ж ця помилка...?");
        throw new Exception("Ви вірно здагадались - ця помилка із someMethod2");
    }

    public static void someMethod() throws Exception {
        System.out.println("Я пишу із someMethod");
        someMethod2();
    }

    public static void main(String[] args) {
        try {
            someMethod();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
