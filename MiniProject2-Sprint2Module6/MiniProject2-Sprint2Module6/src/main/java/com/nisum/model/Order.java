package com.nisum.model;
import java.util.Date;

public class Order {
    private int orderId;
    private int userId;
    private Date orderDate;
    private String orderStatus;
    private double orderTotal;
    private int sellerId;
    private int warehouseId;

    public Order() {}

    public Order(int orderId, int userId, Date orderDate, String orderStatus, double orderTotal, int sellerId, int warehouseId) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderTotal = orderTotal;
        this.sellerId = sellerId;
        this.warehouseId = warehouseId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

}

