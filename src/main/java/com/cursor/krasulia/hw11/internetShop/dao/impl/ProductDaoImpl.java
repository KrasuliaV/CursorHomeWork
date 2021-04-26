package com.cursor.krasulia.hw11.internetShop.dao.impl;

import com.cursor.krasulia.hw11.internetShop.dao.ProductDao;
import com.cursor.krasulia.hw11.internetShop.homeDB.HomeDB;
import com.cursor.krasulia.hw11.internetShop.model.Product;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static long productId = 3;

    @Override
    public synchronized Product create(Product product) {
        productId++;
        product.setId(productId);
        HomeDB.getProductDB().add(product);
        return product;
    }

    @Override
    public Product getById(Long id) {
        return HomeDB.getProductDB().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public synchronized Product delete(Product product) {
        HomeDB.getProductDB().remove(product);
        return product;
    }

    @Override
    public synchronized Product update(Product product) {
        return HomeDB.getProductDB().set(HomeDB.getProductDB().indexOf(getById(product.getId())), product);
    }

    @Override
    public List<Product> getAll() {
        return HomeDB.getProductDB();
    }
}
