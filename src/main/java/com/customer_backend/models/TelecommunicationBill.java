package com.customer_backend.models;

import javax.persistence.*;

@Entity
@Table(name = "telecommunication_bills")
public class TelecommunicationBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tel_pay_id")
    private int telPayId;

    @Column(name = "payment_id", nullable = false)
    private int paymentId;

    @Column(name = "tel_no", nullable = false)
    private String telNo;

    @Column(name = "amount", nullable = false)
    private double amount;

    // Getters and Setters
    public int getTelPayId() {
        return telPayId;
    }

    public void setTelPayId(int telPayId) {
        this.telPayId = telPayId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}