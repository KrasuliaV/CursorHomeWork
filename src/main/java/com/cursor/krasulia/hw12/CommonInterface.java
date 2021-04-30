package com.cursor.krasulia.hw12;

import java.util.Scanner;

public interface CommonInterface {

    Scanner scanner = new Scanner(System.in);

    default void showItems(String[] items) {
        for (String item : items) {
            System.out.printf("%s%-25s%s%n", "\033[1;33m", item, "\033[0m");
        }
    }

    default void exit() {
        scanner.close();
        System.exit(0);
    }

    default void goToMainMenu() {
        new MainMenu().showMainMenu();
    }
}
