package com.cursor.krasulia.hw11.internetShop.dao.impl;

import com.cursor.krasulia.hw11.internetShop.dao.PurchaseDao;
import com.cursor.krasulia.hw11.internetShop.homeDB.HomeDB;
import com.cursor.krasulia.hw11.internetShop.model.Purchase;
import com.cursor.krasulia.hw11.internetShop.model.User;

public class PurchaseDaoImpl implements PurchaseDao {
    private static long orderId = 3;

    @Override
    public synchronized Purchase create(Purchase purchase) {
        orderId++;
        purchase.setId(orderId);
        getUserByPurchaseOwner(purchase).getPurchases().add(purchase);
        return purchase;
    }

    private User getUserByPurchaseOwner(Purchase purchase) {
        return HomeDB.getUsersDB().stream()
                .filter(user -> user.getUsername().equals(purchase.getOwnerName()))
                .findFirst()
                .orElse(new User());
    }
}
