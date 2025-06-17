package com.nisum.model;

public class ShipmentItem {
    private int shipmentItemId;
    private int shipmentId;
    private int orderItemId;
    private int shippedQty;

    public ShipmentItem(int shipmentItemId, int shipmentId, int orderItemId, int shippedQty) {
        this.shipmentItemId = shipmentItemId;
        this.shipmentId = shipmentId;
        this.orderItemId = orderItemId;
        this.shippedQty = shippedQty;
    }

    public int getShipmentItemId() {
        return shipmentItemId;
    }

    public void setShipmentItemId(int shipmentItemId) {
        this.shipmentItemId = shipmentItemId;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getShippedQty() {
        return shippedQty;
    }

    public void setShippedQty(int shippedQty) {
        this.shippedQty = shippedQty;
    }

    // Getters and setters
}

