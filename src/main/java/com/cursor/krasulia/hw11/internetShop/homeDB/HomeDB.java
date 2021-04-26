package com.cursor.krasulia.hw11.internetShop.homeDB;

import com.cursor.krasulia.hw11.internetShop.model.Product;
import com.cursor.krasulia.hw11.internetShop.model.Purchase;
import com.cursor.krasulia.hw11.internetShop.model.User;

import java.util.ArrayList;
import java.util.List;

public class HomeDB {

    private static ArrayList<Product> productDB;
    private static ArrayList<User> usersDB;

    static {
        Product banana = new Product(1L, "Banana", 32.59);
        Product apple = new Product(2L, "Apple", 22.74);
        Product honey = new Product(3L, "Honey", 150.21);
        Purchase firstPurchase = new Purchase(1L, "goga", 5444_5555L, new ArrayList<>(List.of(banana, honey)));
        Purchase secondPurchase = new Purchase(2L, "tosha", 5444_4955L, new ArrayList<>(List.of(apple, honey)));
        Purchase thirdPurchase = new Purchase(3L, "glavniy", 5444_5578L, new ArrayList<>(List.of(banana, apple)));
        productDB = new ArrayList<>(List.of(banana, apple, honey));
        usersDB = new ArrayList<>(
                List.of(new User(1L, "goga", "granata", 5444_5555L,
                                new ArrayList<>(List.of(firstPurchase))),
                        new User(2L, "tosha", "pernatiy", 5444_4955L,
                                new ArrayList<>(List.of(secondPurchase))),
                        new User(3L, "glavniy", "pahan", 5444_5578L,
                                new ArrayList<>(List.of(thirdPurchase)))));
    }

    public static ArrayList<Product> getProductDB() {
        return productDB;
    }

    public static ArrayList<User> getUsersDB() {
        return usersDB;
    }
}
