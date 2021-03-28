package com.cursor.krasulia.hw3.task2.product.electonics_product;

import com.cursor.krasulia.hw3.task2.AgeRestriction;

public class Computer extends ElectonicsProduct {
    public Computer(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction, 24);
    }

    @Override
    public double getPrice() {
        if (super.getQuantity() > 1000) {
            return getPrice() * 0.95;
        } else {
            return getPrice();
        }
    }
}
