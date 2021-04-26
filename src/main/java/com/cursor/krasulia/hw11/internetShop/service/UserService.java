package com.cursor.krasulia.hw11.internetShop.service;

import com.cursor.krasulia.hw11.internetShop.model.User;

public interface UserService {
    User login(String login, String password);

    User register(String login, String password);
}
