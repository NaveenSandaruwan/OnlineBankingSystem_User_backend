package com.customer_backend.dto;

public class WaterBillPaymentRequest {
    private int userId;
    private String accountNumber;
    private String waterAccountNo;
    private double amount;

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getWaterAccountNo() {
        return waterAccountNo;
    }

    public void setWaterAccountNo(String waterAccountNo) {
        this.waterAccountNo = waterAccountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}