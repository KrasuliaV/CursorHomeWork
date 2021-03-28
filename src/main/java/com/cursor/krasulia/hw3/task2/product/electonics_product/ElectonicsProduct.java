package com.cursor.krasulia.hw3.task2.product.electonics_product;

import com.cursor.krasulia.hw3.task2.AgeRestriction;
import com.cursor.krasulia.hw3.task2.product.Product;

public class ElectonicsProduct extends Product {

    private int guaranteePeriod;

    public ElectonicsProduct(String name, double price, int quantity, AgeRestriction ageRestriction, int guaranteePeriod) {
        super(name, price, quantity, ageRestriction);
        this.guaranteePeriod = guaranteePeriod;
    }

}
