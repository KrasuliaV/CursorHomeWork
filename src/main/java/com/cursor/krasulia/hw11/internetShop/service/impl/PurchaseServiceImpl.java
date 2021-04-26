package com.cursor.krasulia.hw11.internetShop.service.impl;

import com.cursor.krasulia.hw11.internetShop.dao.ProductDao;
import com.cursor.krasulia.hw11.internetShop.dao.PurchaseDao;
import com.cursor.krasulia.hw11.internetShop.dao.impl.ProductDaoImpl;
import com.cursor.krasulia.hw11.internetShop.dao.impl.PurchaseDaoImpl;
import com.cursor.krasulia.hw11.internetShop.model.*;
import com.cursor.krasulia.hw11.internetShop.service.PurchaseService;

import java.util.ArrayList;

public class PurchaseServiceImpl implements PurchaseService {

    private final ProductDao productDao;
    private final PurchaseDao purchaseDao;

    public PurchaseServiceImpl() {
        this.productDao = new ProductDaoImpl();
        this.purchaseDao = new PurchaseDaoImpl();
    }

    @Override
    public synchronized void confirmShoppingCart(ShoppingCart shoppingCart, User user, String address) {
        if (shoppingCart != null && user != null) {
            Purchase purchase = new Purchase(user.getUsername(), user.getCardNumber(), new ArrayList<>(shoppingCart.getProductList()));
            if (address != null) {
                Shipping shipping = new Shipping(address);
                purchase.setShipping(shipping);
            }
            purchaseDao.create(purchase);
        }
    }

    @Override
    public synchronized boolean addProductToShoppingCart(ShoppingCart shoppingCart, String productId) {
        if (productId.matches("[\\d]+")) {
            Product product = productDao.getById(Long.parseLong(productId));
            if (product != null) {
                shoppingCart.getProductList().add(product);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
