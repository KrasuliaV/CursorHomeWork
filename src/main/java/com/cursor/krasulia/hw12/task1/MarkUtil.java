package com.cursor.krasulia.hw12.task1;

import com.cursor.krasulia.hw12.CommonInterface;

import java.util.Locale;

public class MarkUtil implements CommonInterface {

    private String[] items = {"1.Numeric to Text", "2.Text to numeric", "0.Exit", "M.Main Menu"};

    public void startConvert() {
        System.out.printf("%sEnter converter number%s%n", "\033[1;92m", "\033[0m");
        showItems(items);
        switch (scanner.nextLine().toUpperCase(Locale.ROOT)) {
            case "1" -> converterNumericalToTextMark();
            case "2" -> converterTextMarkToNumericalMark();
            case "0" -> exit();
            case "M" -> goToMainMenu();
            default -> startConvert();
        }
        startConvert();
    }

    private void converterNumericalToTextMark() {
        System.out.println("Enter mark from 0 to 10");
        String textMark = switch (scanner.nextLine()) {
            case "0", "1", "2", "3", "4" -> "Very Bad";
            case "5" -> "Bad";
            case "6" -> "Acceptable";
            case "7", "8" -> "Good";
            case "9", "10" -> "Well";
            default -> "It's not right numeric mark. You can try again";
        };
        beautyMarkPainter(textMark);
    }


    private void converterTextMarkToNumericalMark() {
        System.out.println("You can enter mark: Very Bad, Bad, Acceptable, Good or Well");
        String answer = scanner.nextLine();
        String almostNumericalMark = switch (answer) {
            case "Very Bad" -> "Your mark one of 1, 2, 3, 4";
            case "Bad" -> "Your mark 5";
            case "Acceptable" -> "Your mark 6";
            case "Good" -> "Your mark 7 or 8";
            case "Well" -> "Your mark 9 or 10";
            default -> "It's not right text mark. You can try again";
        };
        beautyMarkPainter(almostNumericalMark);
    }

    private void beautyMarkPainter(String mark) {
        System.out.printf("%s%s%s%n", "\033[1;35m", mark, "\033[0m");
    }

}
