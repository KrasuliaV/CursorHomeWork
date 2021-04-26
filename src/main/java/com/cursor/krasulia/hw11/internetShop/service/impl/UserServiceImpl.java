package com.cursor.krasulia.hw11.internetShop.service.impl;

import com.cursor.krasulia.hw11.internetShop.dao.UserDao;
import com.cursor.krasulia.hw11.internetShop.dao.impl.UserDaoImpl;
import com.cursor.krasulia.hw11.internetShop.model.User;
import com.cursor.krasulia.hw11.internetShop.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User login(String username, String password) {
        return userDao.getByUsernameAndPassword(username, password);
    }

    @Override
    public synchronized User register(String username, String password) {
        if (login(username, password) == null) {
            return userDao.create(new User(username, password));
        } else {
            return login(username, password);
        }
    }
}
