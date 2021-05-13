package com.cursor.krasulia.hw14;

import java.util.Arrays;

public class Test {
    private static final String SONG_TEXT_FILE_NAME = "data.txt";

    public static void main(String[] args) {
        System.out.printf("In the file %d words%n", FileCheckerUtil.countWord(SONG_TEXT_FILE_NAME));
        System.out.printf("Max repeatable word: %s%n", FileCheckerUtil.getMaxRepeatableWord(SONG_TEXT_FILE_NAME));
        System.out.printf("Array with excluded words %n%s%n", Arrays.toString(FileCheckerUtil.getExcludeWords(SONG_TEXT_FILE_NAME)));
        System.out.println("Amount of words that was removed from file: " + FileCheckerUtil.getExcludeWords(SONG_TEXT_FILE_NAME).length);
    }
}
