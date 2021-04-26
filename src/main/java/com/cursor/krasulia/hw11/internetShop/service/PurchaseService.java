package com.cursor.krasulia.hw11.internetShop.service;

import com.cursor.krasulia.hw11.internetShop.model.ShoppingCart;
import com.cursor.krasulia.hw11.internetShop.model.User;

public interface PurchaseService {
    boolean addProductToShoppingCart(ShoppingCart shoppingCart, String choice);

    void confirmShoppingCart(ShoppingCart shoppingCart, User user, String address);
}
