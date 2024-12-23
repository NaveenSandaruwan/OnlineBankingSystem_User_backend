package com.customer_backend.models;

import javax.persistence.*;

@Entity
@Table(name = "water_bills")
public class WaterBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "water_pay_id")
    private int waterPayId;

    @Column(name = "payment_id", nullable = false)
    private int paymentId;

    @Column(name = "water_account_no", nullable = false)
    private String waterAccountNo;

    @Column(name = "amount", nullable = false)
    private double amount;

    // Getters and Setters
    public int getWaterPayId() {
        return waterPayId;
    }

    public void setWaterPayId(int waterPayId) {
        this.waterPayId = waterPayId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
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