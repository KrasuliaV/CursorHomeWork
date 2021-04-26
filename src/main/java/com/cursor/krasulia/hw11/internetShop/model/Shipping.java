package com.cursor.krasulia.hw11.internetShop.model;

import java.math.BigDecimal;

public class Shipping {

    private String address;

    private String courierName;

    private BigDecimal shippingPrice;

    public Shipping(String address) {
        this.address = address;
        this.courierName = "Speedy";
        this.shippingPrice = BigDecimal.valueOf(Math.random() * 500 + 50);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public BigDecimal getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "address='" + address + '\'' +
                ", courierName='" + courierName + '\'' +
                ", shippingPrice=" + String.format("%.3f", shippingPrice) +
                '}';
    }
}
