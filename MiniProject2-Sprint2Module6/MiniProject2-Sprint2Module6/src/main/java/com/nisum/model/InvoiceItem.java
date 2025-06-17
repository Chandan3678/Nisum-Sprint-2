package com.nisum.model;

public class InvoiceItem {
    private int invoiceItemId;
    private int invoiceId;
    private int orderItemId;
    private int quantity;
    private double unitPrice;
    private double discount;
    private double finalPrice;

    public InvoiceItem(int invoiceItemId, int invoiceId, int orderItemId, int quantity, double unitPrice, double discount, double finalPrice) {
        this.invoiceItemId = invoiceItemId;
        this.invoiceId = invoiceId;
        this.orderItemId = orderItemId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.finalPrice = finalPrice;
    }

    public int getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(int invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
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


    // Getters and setters
}

