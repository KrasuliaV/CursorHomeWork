package com.cursor.krasulia.hw11.internetShop.view.impl;


import com.cursor.krasulia.hw11.internetShop.model.User;
import com.cursor.krasulia.hw11.internetShop.service.UserService;
import com.cursor.krasulia.hw11.internetShop.service.impl.UserServiceImpl;
import com.cursor.krasulia.hw11.internetShop.view.Menu;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiFunction;

public class LoginMenu implements Menu {

    private final UserService userService;
    private final String[] loginMenuItems = {"1.Login", "2.Register", "0. Exit"};
    private final Scanner scanner;

    public LoginMenu() {
        this.userService = new UserServiceImpl();
        scanner = new Scanner(System.in);
    }

    public void show() {
        showItems(loginMenuItems);

        switch (scanner.next()) {
            case "1":
                loginSubMenu();
                break;
            case "2":
                registerSubMenu();
                break;
            case "0":
                exit();
                break;
            default:
                System.out.println("Enter right operation number");
                this.show();
        }
    }

    private void loginSubMenu() {
        User user = getUser(userService::login);
        if (Optional.ofNullable(user).isPresent()) {
            new UserMenu().showMenu(user);
        } else {
            System.out.println("Wrong username/password");
            show();
        }
    }

    private void registerSubMenu() {
        User user = getUser(userService::register);
        new UserMenu().showMenu(user);
    }

    private User getUser(BiFunction<String, String, User> method) {
        System.out.println("input login:");
        String login = scanner.next();

        System.out.println("input password:");
        String password = scanner.next();
        return method.apply(login, password);
    }

    @Override
    public void exit() {
        System.exit(1);
    }
}
