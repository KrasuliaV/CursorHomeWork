package com.cursor.krasulia.hw3.task2.dao;

import com.cursor.krasulia.hw3.task2.enteties.AgeRestriction;
import com.cursor.krasulia.hw3.task2.exception.SecondTaskException;
import com.cursor.krasulia.hw3.task2.enteties.product.Product;
import com.cursor.krasulia.hw3.task2.enteties.product.electonics_product.Appliance;
import com.cursor.krasulia.hw3.task2.enteties.product.electonics_product.Computer;
import com.cursor.krasulia.hw3.task2.enteties.product.food_product.FoodProduct;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.cursor.krasulia.hw3.task2.enteties.AgeRestriction.*;

public class ProductDAO {
    private static List<Product> productList;

    static {
        productList = new ArrayList<>();

        productList.add(new FoodProduct("Banana", 20, 150, NONE, 30));
        productList.add(new FoodProduct("Whisky", 790, 200, ADULT, 500));
        productList.add(new FoodProduct("Cheese", 123, 80, NONE, 121));
        productList.add(new FoodProduct("Cheeps", 12, 50, TEENAGER, 720));
        productList.add(new FoodProduct("Сigars", 6.9, 1400, ADULT, 954));
        productList.add(new Computer("MacBook", 22000.00, 115, NONE));
        productList.add(new Computer("Lenovo", 15000.00, 217, NONE));
        productList.add(new Computer("HP", 14000.00, 184, ADULT));
        productList.add(new Appliance("Watch", 17000.00, 101, ADULT));
        productList.add(new Appliance("Multicookers", 1200.00, 554, NONE));
        productList.add(new Appliance("Coffee machines", 1100.00, 522, ADULT));
        productList.add(new Appliance("Refrigerators", 1100.00, 370, NONE));
    }

    public static boolean addProduct(Product product) {
        return productList.add(product);
    }

    public static boolean deleteProduct(Product product) {
        return productList.remove(product);
    }

    public static Product getProductByName(String name) {
        if (name != null) {
            return productList.stream()
                    .filter(prod -> name.equals(prod.getName()))
                    .findFirst()
                    .orElseThrow(() -> new SecondTaskException("There is no such product!!"));
        } else {
            throw new SecondTaskException("You must get product name!!!");
        }
    }

    public static Product getProductWithSoonestExpirationDate() {
        return productList.stream()
                .filter(prod -> FoodProduct.class.equals(prod.getClass()))
                .map(FoodProduct.class::cast)
                .min(Comparator.comparing(FoodProduct::getExpirationDate))
                .orElseThrow(() -> new SecondTaskException("There are no product with expiration"));
    }

    public static List<Product> getAgeRestrictionProductListSortedByPriceList(AgeRestriction ageRestriction) {
        if (ageRestriction != null) {
            return productList.stream()
                    .filter(someProduct -> ageRestriction.equals(someProduct.getAgeRestriction()))
                    .sorted(Comparator.comparing(Product::getPrice))
                    .collect(Collectors.toList());
        } else {
            throw new SecondTaskException("You need age restriction product name!!!");
        }
    }

    public static Product getRandomProduct() {
        return productList.get(new Random().nextInt(productList.size() - 1) + 1);
    }

}
