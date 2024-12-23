package com.customer_backend.models;

import javax.persistence.*;

@Entity
@Table(name = "insurance_bills")
public class InsuranceBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ins_pay_id")
    private int insPayId;

    @Column(name = "payment_id", nullable = false)
    private int paymentId;

    @Column(name = "insurance_no", nullable = false)
    private String insuranceNo;

    @Column(name = "amount", nullable = false)
    private double amount;

    // Getters and Setters
    public int getInsPayId() {
        return insPayId;
    }

    public void setInsPayId(int insPayId) {
        this.insPayId = insPayId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}