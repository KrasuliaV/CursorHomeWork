package com.cursor.krasulia.hw3.task2.service;

import com.cursor.krasulia.hw3.task2.enteties.AgeRestriction;
import com.cursor.krasulia.hw3.task2.enteties.Customer;
import com.cursor.krasulia.hw3.task2.enteties.product.Product;
import com.cursor.krasulia.hw3.task2.enteties.product.food_product.FoodProduct;
import com.cursor.krasulia.hw3.task2.exception.SecondTaskException;

import java.util.Date;

public class PurchaseManager {

    public static void processPurchase(Product product, Customer customer) {
        if (customer.getAge() < 18 && product.getAgeRestriction().equals(AgeRestriction.TEENAGER)) {
            throw new SecondTaskException(customer.getName() + ", you are too young to buy this product!");
        }
        double newBalance = customer.getBalance() - product.getPrice();
        int newQuantity = product.getQuantity() - 1;
        if (newBalance < 0) {
            throw new SecondTaskException(customer.getName() + ", you do not have enough money to buy this product!");
        }
        if (newQuantity < 0) {
            throw new SecondTaskException("Shop do not have enough " + product.getName() + "!");
        }
        if (product instanceof FoodProduct) {
            if (((FoodProduct) product).getExpirationDate().before(new Date(System.currentTimeMillis()))) {
                throw new SecondTaskException("The " + product.getName() + " has expired");
            }
        }
        customer.setBalance(newBalance);
        product.setQuantity(newQuantity);
    }
}
