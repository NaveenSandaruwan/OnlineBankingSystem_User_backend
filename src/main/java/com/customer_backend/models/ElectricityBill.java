package com.customer_backend.models;

import javax.persistence.*;

@Entity
@Table(name = "electricity_bills")
public class ElectricityBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "elec_pay_id")
    private int elecPayId;

    @Column(name = "payment_id", nullable = false)
    private int paymentId;

    @Column(name = "electricity_account_no", nullable = false)
    private String electricityAccountNo;

    @Column(name = "amount", nullable = false)
    private double amount;

    // Getters and Setters
    public int getElecPayId() {
        return elecPayId;
    }

    public void setElecPayId(int elecPayId) {
        this.elecPayId = elecPayId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
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