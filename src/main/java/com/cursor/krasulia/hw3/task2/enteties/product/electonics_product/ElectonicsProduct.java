package com.cursor.krasulia.hw3.task2.enteties.product.electonics_product;

import com.cursor.krasulia.hw3.task2.enteties.AgeRestriction;
import com.cursor.krasulia.hw3.task2.enteties.product.Product;

public class ElectonicsProduct extends Product {

    private int guaranteePeriod;

    public ElectonicsProduct(String name, double price, int quantity, AgeRestriction ageRestriction, int guaranteePeriod) {
        super(name, price, quantity, ageRestriction);
        this.guaranteePeriod = guaranteePeriod;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", guaranteePeriod=" + guaranteePeriod;
    }
}
