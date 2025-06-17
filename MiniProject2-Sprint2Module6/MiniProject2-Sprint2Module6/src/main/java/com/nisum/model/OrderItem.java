package com.nisum.model;

public class OrderItem {
    private int orderItemId;
    private int orderId;
    private int productId;
    private String sku;
    private int quantity;
    private double unitPrice;
    private double discount;
    private double finalPrice;
    private String size;
    private String color;
    private String status;

    public OrderItem() {}

    public OrderItem(int orderItemId, int orderId, int productId, String sku, int quantity,
                     double unitPrice, double discount, double finalPrice,
                     String size, String color, String status) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.productId = productId;
        this.sku = sku;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.size = size;
        this.color = color;
        this.status = status;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
