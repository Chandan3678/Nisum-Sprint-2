package com.nisum.model;

import java.sql.Date;

public class Invoice {
    private int invoiceId;
    private int orderId;
    private String invoiceNumber;
    private Date invoiceDate;
    private String paymentMode;
    private double invoiceAmount;

    public Invoice(int invoiceId, int orderId, String invoiceNumber, Date invoiceDate, String paymentMode, double invoiceAmount) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.paymentMode = paymentMode;
        this.invoiceAmount = invoiceAmount;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    // Getters and setters
}

