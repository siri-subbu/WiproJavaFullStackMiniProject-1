package com.hibernate.assignment.model;

public class Product {
    private int productId;
    private String productName;
    private double price;

    public Product() {}
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}