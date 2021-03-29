package com.cursor.krasulia.hw3.task2.enteties.product.food_product;

import com.cursor.krasulia.hw3.task2.enteties.AgeRestriction;
import com.cursor.krasulia.hw3.task2.enteties.product.Expirable;
import com.cursor.krasulia.hw3.task2.enteties.product.Product;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FoodProduct extends Product implements Expirable {

    private Date expirationDate;

    public FoodProduct(String name, double price, int quantity, AgeRestriction ageRestriction, int expirationDateInDays) {
        super(name, price, quantity, ageRestriction);
        this.expirationDate = convertToExpirationDate(expirationDateInDays);
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setExpirationDate(int expirationDateInDays) {
        this.expirationDate = convertToExpirationDate(expirationDateInDays);
    }

    @Override
    public Date getExpirationDate() {
        return expirationDate;
    }

    @Override
    public double getPrice() {
        if (TimeUnit.MILLISECONDS.toDays(expirationDate.getTime() - System.currentTimeMillis()) <= 15) {
            return super.getPrice() * 0.7;
        }
        return super.getPrice();
    }

    private Date convertToExpirationDate(int expirationDateInDays) {
        return new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(expirationDateInDays));
    }

    @Override
    public String toString() {
        return super.toString() +
                ", expirationDate = " + new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss").format(expirationDate);
    }
}
