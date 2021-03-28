package com.cursor.krasulia.hw3.task2;

import com.cursor.krasulia.hw3.task2.product.Product;
import com.cursor.krasulia.hw3.task2.product.food_product.FoodProduct;

import java.util.Date;

public class PurchaseManager {

    public static void processPurchase(Product product, Customer customer) {
        if (customer.getAge() < 18 && product.getAgeRestriction().equals(AgeRestriction.TEENAGER)) {
            throw new SecondTaskException("You are too young to buy this product!");
        }
        double newBalance = customer.getBalance() - product.getPrice();
        int newQuantity = product.getQuantity() - 1;
        if (newBalance < 0) {
            throw new SecondTaskException("You do not have enough money to buy this product!");
        }
        if (newQuantity < 0) {
            throw new SecondTaskException("Shop do not have enough product!");
        }
        if (product instanceof FoodProduct) {
            if (((FoodProduct) product).getExpirationDate().before(new Date(System.currentTimeMillis()))) {
                throw new SecondTaskException("The product has expired");
            }
        }
        customer.setBalance(newBalance);
        product.setQuantity(newQuantity);
    }
}
