package com.cursor.krasulia.hw11.internetShop.model;

import java.util.ArrayList;
import java.util.List;

public class User extends AbstractEntity {

    private String username;

    private String password;

    private long cardNumber;

    private List<Purchase> purchases;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.purchases = new ArrayList<>();
    }

    public User(Long id, String username, String password, long cardNumber, List<Purchase> purchases) {
        super(id);
        this.username = username;
        this.password = password;
        this.cardNumber = cardNumber;
        this.purchases = purchases;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }
}
