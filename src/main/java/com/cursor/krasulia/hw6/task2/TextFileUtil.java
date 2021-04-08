package com.cursor.krasulia.hw6.task2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextFileUtil {

    private TextFileUtil() {
    }

    private static final String URL = "https://drive.google.com/u/1/uc?id=1xNjdaKxMvay5dzQ8rLxSmbh_SZqmuEy1&export=download";
    private static final String FILE_NAME = "Tolstoi_Lev__Voina_i_mir._Tom_1.txt";

    public static String getTheLongestWord() {
        copyFileByURL(URL, FILE_NAME);
        try {
            return getStringWithMaxLength(
                    getEntryWithStringWithMaxLength(
                            extractStringFromFile(FILE_NAME)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTheShortestWord() {
        copyFileByURL(URL, FILE_NAME);
        try {
            return getStringWithMinLength(
                    getEntryWithStringWithMinLength(
                            extractStringFromFile(FILE_NAME)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getStringWithMaxLength(Map.Entry<String, Long> mapEntry) {
        return String.format("In yor file world with max length is: %s." +
                        "\nThis world was repeated %d",
                mapEntry.getKey(),
                mapEntry.getValue());
    }

    private static String getStringWithMinLength(Map.Entry<String, Long> mapEntry) {
        return String.format("In yor file world with min length is: %s." +
                        "\nThis world was repeated %d",
                mapEntry.getKey(),
                mapEntry.getValue());
    }

    private static void copyFileByURL(String urlString, String fileName) {
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            URL url = new URL(urlString);
            out.write(url.openStream().readAllBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Map<String, Long> extractStringFromFile(String fileName) throws IOException {
        return Files.lines(Path.of(fileName))
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .flatMap(str -> Arrays.stream(str.split("\\.")))
                .map(String::toLowerCase)
                .map(str -> str.replaceAll("[^(a-zа-я'éê)]", ""))
                .map(str -> str.replaceAll("[\\(]", "")) // little crutch
                .filter(str -> str.length() > 2)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
    }

    private static Map.Entry<String, Long> getEntryWithStringWithMaxLength(Map<String, Long> map) {
        return map.entrySet().stream()
                .max(Comparator.comparingInt(str -> str.getKey().length()))
                .orElseThrow(NoSuchElementException::new);
    }

    private static Map.Entry<String, Long> getEntryWithStringWithMinLength(Map<String, Long> map) {
        return map.entrySet().stream()
                .min(Comparator.comparingInt(str -> str.getKey().length()))
                .orElseThrow(NoSuchElementException::new);
    }
}
