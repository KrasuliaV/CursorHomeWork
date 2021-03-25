package com.cursor.krasulia.hw2.task2;

public class CountingSelfObjectsClass {
    private static long classObjectsNumber = 0;

    public CountingSelfObjectsClass() {
        classObjectsNumber++;
    }

    public static long getClassObjectsNumber() {
        return classObjectsNumber;
    }
}
