package com.customer_backend.dto;

public class ElectricityBillPaymentRequest {
    private int userId;
    private String accountNumber;
    private String electricityAccountNo;
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

    public String getElectricityAccountNo() {
        return electricityAccountNo;
    }

    public void setElectricityAccountNo(String electricityAccountNo) {
        this.electricityAccountNo = electricityAccountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}