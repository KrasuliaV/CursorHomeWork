package com.cursor.krasulia.hw12;

import com.cursor.krasulia.hw12.task1.MarkUtil;
import com.cursor.krasulia.hw12.task2.PercentFinder;

import java.util.Scanner;

public class MainMenu implements CommonInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] items = {"1.UniqueNumbers", "2.Marks", "0.Exit"};

    public void showMainMenu() {
        System.out.println("Choose exercise");
        showItems(items);
        switch (scanner.nextLine()) {
            case "1" -> new PercentFinder().startUniqueNumberPercentFinder();
            case "2" -> new MarkUtil().startConvert();
            case "0" -> exit();
            default -> showMainMenu();
        }
        showMainMenu();
    }


}
