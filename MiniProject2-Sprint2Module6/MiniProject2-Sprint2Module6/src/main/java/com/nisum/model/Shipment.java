package com.nisum.model;

import java.util.List;

public class Shipment {
    private int shipmentId;
    private int orderId;
    private String shipmentStatus;
    private String shipmentTrackingId;
    private String shipmentDate;
    private String deliveredDate;

    public Shipment(int shipmentId, int orderId, String shipmentStatus, String shipmentTrackingId, String shipmentDate, String deliveredDate) {
        this.shipmentId = shipmentId;
        this.orderId = orderId;
        this.shipmentStatus = shipmentStatus;
        this.shipmentTrackingId = shipmentTrackingId;
        this.shipmentDate = shipmentDate;
        this.deliveredDate = deliveredDate;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public String getShipmentTrackingId() {
        return shipmentTrackingId;
    }

    public void setShipmentTrackingId(String shipmentTrackingId) {
        this.shipmentTrackingId = shipmentTrackingId;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(String deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    private List<ShipmentItem> shipmentItems;

    // Add getter and setter
    public List<ShipmentItem> getShipmentItems() { return shipmentItems; }
    public void setShipmentItems(List<ShipmentItem> shipmentItems) { this.shipmentItems = shipmentItems; }

}
