package com.cursor.krasulia.hw6.task1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringUtil {

    private StringUtil() {
    }

    public static Map<String, Long> getNumberStringsLetter(String someString) {
        if (someString == null || someString.length() == 0) return new HashMap<>();
        return Arrays.stream(someString.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static long getLetterNumber(String someString) {
        if (someString == null || someString.length() == 0) return 0;
        return Arrays.stream(someString.split(""))
                .map(String::toLowerCase)
                .filter(el -> el.matches("[\\w]"))
                .count();
    }

    public static long getWhitespaceNumber(String someString) {
        if (someString == null || someString.length() == 0) return 0;
        return getNumberStringsLetter(someString).get(" ");
    }

    public static long getNumberOfDigits(String someString) {
        if (someString == null || someString.length() == 0) return 0;
        return Arrays.stream(someString.split(""))
                .map(String::toLowerCase)
                .filter(el -> el.matches("[\\d]"))
                .count();
    }

    public static long getPunctuationNumber(String someString) {
        if (someString == null || someString.length() == 0) return 0;
        return Arrays.stream(someString.split(""))
                .map(String::toLowerCase)
                .filter(el -> el.matches("[^\\s\\d\\w]"))
                .count();
    }
}
