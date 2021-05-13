package com.cursor.krasulia.hw14;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCheckerUtil {

    private FileCheckerUtil() {
    }

    private static final String BAD_WORDS_FILE_NAME = "bad_words.txt";

    /**
     * Counting all word in file by passing file name.
     * Params:   fileName – file name for word extracting
     * Returns:  the number of word in file
     * Throws:   NullPointerException – if passing null into parameter
     */
    public static long countWord(String fileName) {
        return Optional.ofNullable(getStringFromFile(fileName)).orElse(Collections.emptyList()).size();
    }

    /**
     * Getting list without bad words and words with length less then 3.
     * Params:   fileName – file name for word extracting
     * Returns:  list with word
     */
    public static List<String> cleaningCollectionFromWrongWords(String fileName) {
        List<String> badWords = getStringFromFile(BAD_WORDS_FILE_NAME);
        List<String> allWords = getStringFromFile(fileName);

        if (allWords == null) {
            return Collections.emptyList();
        }

        allWords.removeAll(badWords);
        return allWords.stream()
                .filter(word -> word.length() > 2)
                .collect(Collectors.toList());
    }

    /**
     * Getting map with unique words as key and them amount as a value from file.
     * Params:   fileName – file name for word extracting
     * Returns:  map with words and them amount
     */
    public static Map<String, Long> getMapWithWordsAmount(String fileName) {
        return cleaningCollectionFromWrongWords(fileName).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Getting Map.Entry with max repeatable word  from file.
     * Params:   fileName – file name for word extracting
     * Returns:  Entry with max repeatable word
     * Throws:   NoSuchElementException – if don't have max element
     */
    public static Map.Entry<String, Long> getMaxRepeatableWord(String fileName) {
        return getMapWithWordsAmount(fileName).entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow(NoSuchElementException::new);
    }

    /**
     * Getting string array with excluded words.
     * Returns:  string array
     */
    public static String[] getExcludeWords(String fileName) {
        if (fileName == null) {
            return new String[0];
        }
        final List<String> words = getStringFromFile(fileName);
        words.removeAll(cleaningCollectionFromWrongWords(fileName));
        return words.toArray(new String[0]);
    }

    /**
     * Extract words from file by file name and returning list with this word.
     * Params:   fileName – file name for word extracting
     * Returns:  the resulting list
     * Throws:   URISyntaxException – if string could not be parsed as a URI reference
     * NullPointerException – if passing wrong file name
     */
    private static List<String> getStringFromFile(String fileName) {
        List<String> lines = null;
        try {
            Path textFile = Paths.get(FileCheckerUtil.class.getResource("/" + fileName).toURI());
            lines = getStrings(lines, textFile);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }
        return lines;
    }

    /**
     * Extract words from file by file path, added to passing list and returning this list.
     * Params:   fileName – file name for word extracting
     * textFile – path to file for extracting
     * Returns:  the resulting list
     * Throws:   IOException – it produced by failed or interrupted I/O operations
     * NullPointerException – if passing null into textFile
     */
    private static List<String> getStrings(List<String> lines, Path textFile) {
        try (Stream<String> streamLines = Files.lines(textFile)) {
            lines = streamLines.filter(line -> !line.isBlank())
                    .flatMap(line -> Arrays.stream(line.split(" ").clone()))
                    .map(word -> word.replaceAll("[^\\w']", ""))
                    .collect(Collectors.toList());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return lines;
    }
}
