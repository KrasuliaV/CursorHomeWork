package com.cursor.krasulia.hw3.task2.enteties.product.electonics_product;

import com.cursor.krasulia.hw3.task2.enteties.AgeRestriction;

public class Appliance extends ElectonicsProduct {

    public Appliance(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction, 6);
    }

    @Override
    public double getPrice() {
        if (super.getQuantity() < 50) {
            return super.getPrice() * 1.05;
        } else {
            return super.getPrice();
        }
    }
}
