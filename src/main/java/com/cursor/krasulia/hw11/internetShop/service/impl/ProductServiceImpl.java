package com.cursor.krasulia.hw11.internetShop.service.impl;

import com.cursor.krasulia.hw11.internetShop.dao.impl.ProductDaoImpl;
import com.cursor.krasulia.hw11.internetShop.model.Product;
import com.cursor.krasulia.hw11.internetShop.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDaoImpl productDao;

    public ProductServiceImpl() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public List<Product> getAllProductList() {
        return productDao.getAll();
    }
}
