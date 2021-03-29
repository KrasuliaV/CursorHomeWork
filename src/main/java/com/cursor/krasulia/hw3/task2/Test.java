package com.cursor.krasulia.hw3.task2;

import com.cursor.krasulia.hw3.task2.dao.ProductDAO;
import com.cursor.krasulia.hw3.task2.enteties.AgeRestriction;
import com.cursor.krasulia.hw3.task2.enteties.Customer;
import com.cursor.krasulia.hw3.task2.enteties.product.Product;
import com.cursor.krasulia.hw3.task2.exception.SecondTaskException;
import com.cursor.krasulia.hw3.task2.service.PurchaseManager;

public class Test {
    public static void main(String[] args) {
        Customer pecata = new Customer("Pecata", 17, 35000.00);
        Customer gopeto = new Customer("Gopeto", 18, 1578.44);
        Customer perug = new Customer("Perug", 54, 500.68);
        double pecataBalance = pecata.getBalance();

        Product product = ProductDAO.getRandomProduct();
        System.out.println(product);

        try {
            PurchaseManager.processPurchase(product, pecata);
            PurchaseManager.processPurchase(product, gopeto);
            PurchaseManager.processPurchase(product, perug);
        } catch (SecondTaskException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Product after try block:\nName: " + product.getName() + ", quantity: " + product.getQuantity());
            System.out.println("Pecata balance before try block: " + pecataBalance + "\nPecata balance after try block: " + pecata.getBalance());
        }

        System.out.println("Product with soonest expiration date: " + ProductDAO.getProductWithSoonestExpirationDate().getName());
        System.out.println("Product list for Adult sorted by price:\n" + ProductDAO.getAgeRestrictionProductListSortedByPriceList(AgeRestriction.ADULT));
    }
}
