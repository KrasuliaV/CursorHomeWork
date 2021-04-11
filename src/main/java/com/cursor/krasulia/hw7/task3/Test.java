package com.cursor.krasulia.hw7.task3;

import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        System.out.println(Stream.of("John", "Smith", "John", "Doe", "Jane", "Doe")
                .collect(PersonMakeCollector.toPersonList()));
    }
}
