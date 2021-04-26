package com.cursor.krasulia.hw11.internetShop.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Purchase extends AbstractEntity {

    private String ownerName;

    private long cardNumber;

    private List<Product> productList;

    private BigDecimal totalCost;

    private Shipping shipping;

    public Purchase() {
    }

    public Purchase(String ownerName, long cardNumber, List<Product> productList) {
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.productList = productList;
        this.totalCost = setTotalCost(productList);
    }

    public Purchase(Long id, String ownerName, long cardNumber, List<Product> productList) {
        super(id);
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.productList = productList;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    private BigDecimal setTotalCost(List<Product> productList) {
        BigDecimal totalProductCost = productList.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal(0));
        if (shipping != null) {
            return shipping.getShippingPrice().add(totalProductCost);
        } else {
            return totalProductCost;
        }
    }

    private Map<String, Long> getRightProductList() {
        return productList.stream()
                .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "ownerName='" + ownerName + '\'' +
                ", cardNumber=" + cardNumber +
                ", productList=" + getRightProductList() +
                ", totalCost=" + totalCost +
                ", shipping=" + shipping +
                '}';
    }
}
