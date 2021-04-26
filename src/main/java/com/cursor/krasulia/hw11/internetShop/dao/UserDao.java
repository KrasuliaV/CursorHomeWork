package com.cursor.krasulia.hw11.internetShop.dao;

import com.cursor.krasulia.hw11.internetShop.model.User;

public interface UserDao extends Dao<User> {

    User getByUsernameAndPassword(String username, String password);

    User getByOrderId(String orderId);
}
