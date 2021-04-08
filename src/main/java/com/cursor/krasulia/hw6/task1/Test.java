package com.cursor.krasulia.hw6.task1;

import static com.cursor.krasulia.hw6.task1.StringUtil.*;

public class Test {
    public static void main(String[] args) {
        String str = "   k1l119RRQWrwWRr  .,*&&7&???9664847l,jgj ";
        System.out.println("Letter number: " + getLetterNumber(str));
        System.out.println("Punctuation number: " + getPunctuationNumber(str));
        System.out.println("Number of digits: " + getNumberOfDigits(str));
        System.out.println("Whitespace number: " + getWhitespaceNumber(str));
        System.out.println(getNumberStringsLetter(str));
    }
}
