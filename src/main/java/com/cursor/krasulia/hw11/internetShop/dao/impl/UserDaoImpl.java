package com.cursor.krasulia.hw11.internetShop.dao.impl;

import com.cursor.krasulia.hw11.internetShop.dao.UserDao;
import com.cursor.krasulia.hw11.internetShop.homeDB.HomeDB;
import com.cursor.krasulia.hw11.internetShop.model.Purchase;
import com.cursor.krasulia.hw11.internetShop.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private static Long userId = 3L;

    @Override
    public synchronized User create(User user) {
        userId++;
        user.setId(userId);
        HomeDB.getUsersDB().add(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return HomeDB.getUsersDB().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User delete(User user) {
        HomeDB.getUsersDB().remove(user);
        return user;
    }

    @Override
    public synchronized User update(User user) {
        return HomeDB.getUsersDB().set(HomeDB.getUsersDB().indexOf(getById(user.getId())), user);
    }

    @Override
    public List<User> getAll() {
        return HomeDB.getUsersDB();
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        return HomeDB.getUsersDB().stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getByOrderId(String orderId) {
        return HomeDB.getUsersDB().stream()
                .filter(user -> isThereOrder(user, orderId))
                .findFirst()
                .orElse(null);
    }

    private boolean isThereOrder(User user, String orderId) {
        return user.getPurchases()
                .stream()
                .map(Purchase::getId)
                .anyMatch(id -> id.equals(Long.parseLong(orderId)));
    }
}
