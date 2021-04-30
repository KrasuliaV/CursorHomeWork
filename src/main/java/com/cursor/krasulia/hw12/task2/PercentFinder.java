package com.cursor.krasulia.hw12.task2;

import com.cursor.krasulia.hw12.CommonInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PercentFinder implements CommonInterface {

    private String[] items = {"1.Enter number(only Integer) set", "0.Exit", "M.Main Menu"};
    private final Scanner scanner = new Scanner(System.in);

    public void startUniqueNumberPercentFinder() {
        showItems(items);
        String maybeNumberSet = scanner.nextLine().toUpperCase(Locale.ROOT);
        switch (maybeNumberSet) {
            case "0" -> exit();
            case "M" -> goToMainMenu();
            default -> listChecker(parseToListFromString(maybeNumberSet));
        }
    }

    @SuppressWarnings("unchecked")
    private void listChecker(List<Integer> list) {
        if (list.isEmpty()) {
            System.out.println("You enter incorrect number set");
        } else {
            displayPercentOfUniqueNumbers(list);
        }
        startUniqueNumberPercentFinder();
    }

    public void displayPercentOfUniqueNumbers(List<Integer>... integerList) {
        Arrays.stream(integerList)
                .map(this::getPercentOfUniqueNumbers)
                .map("Percent of unique numbers for this list integers: %s %%"::formatted)
                .forEach(System.out::println);
    }

    public double getPercentOfUniqueNumbers(List<Integer> integerList) {
        return integerList.stream()
                .collect(Collectors.teeing(Collectors.counting(),
                        Collectors.toSet(),
                        (totalNumber, uniqueElNumber) -> (uniqueElNumber.size() / (double) totalNumber) * 100));
    }

    private List<Integer> parseToListFromString(String string) {
        return Arrays.stream(string.split(","))
                .filter(someInt -> someInt.matches("[\\d]+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
