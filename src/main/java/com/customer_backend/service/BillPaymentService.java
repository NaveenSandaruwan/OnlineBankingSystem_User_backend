package com.customer_backend.service;

import com.customer_backend.models.*;
import com.customer_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillPaymentService {

    @Autowired
    private BillPaymentRepository billPaymentRepository;

    @Autowired
    private ElectricityBillRepository electricityBillRepository;

    @Autowired
    private WaterBillRepository waterBillRepository;

    @Autowired
    private TelecommunicationBillRepository telecommunicationBillRepository;

    @Autowired
    private InsuranceBillRepository insuranceBillRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Transactional
    public void addElectricityBillPayment(int userId, String accountNumber, String electricityAccountNo, double amount) {
        try {
            BillPayment billPayment = new BillPayment();
            billPayment.setUserId(userId);
            billPayment.setBillType("Electricity");
            billPayment.setAmount(amount);
            billPayment.setStatus("Paid");
            billPaymentRepository.save(billPayment);

            ElectricityBill electricityBill = new ElectricityBill();
            electricityBill.setPaymentId(billPayment.getPaymentId());
            electricityBill.setElectricityAccountNo(electricityAccountNo);
            electricityBill.setAmount(amount);
            electricityBillRepository.save(electricityBill);

            Account account = accountRepository.findByAccountNumber(accountNumber);
            if (account == null) {
                throw new IllegalArgumentException("Account not found: " + accountNumber);
            }
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);

            AuditLog auditLog = new AuditLog();
            auditLog.setUserId(userId);
            auditLog.setActionType("Transaction");
            auditLog.setDetails("Electricity bill payment of " + amount + " for account " + electricityAccountNo);
            auditLogRepository.save(auditLog);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Insufficient funds for account: " + accountNumber);
        }
    }

    @Transactional
    public void addWaterBillPayment(int userId, String accountNumber, String waterAccountNo, double amount) {
        try {
            BillPayment billPayment = new BillPayment();
            billPayment.setUserId(userId);
            billPayment.setBillType("Water");
            billPayment.setAmount(amount);
            billPayment.setStatus("Paid");
            billPaymentRepository.save(billPayment);

            WaterBill waterBill = new WaterBill();
            waterBill.setPaymentId(billPayment.getPaymentId());
            waterBill.setWaterAccountNo(waterAccountNo);
            waterBill.setAmount(amount);
            waterBillRepository.save(waterBill);

            Account account = accountRepository.findByAccountNumber(accountNumber);
            if (account == null) {
                throw new IllegalArgumentException("Account not found: " + accountNumber);
            }
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);

            AuditLog auditLog = new AuditLog();
            auditLog.setUserId(userId);
            auditLog.setActionType("Transaction");
            auditLog.setDetails("Water bill payment of " + amount + " for account " + waterAccountNo);
            auditLogRepository.save(auditLog);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Insufficient funds for account: " + accountNumber);
        }
    }

    @Transactional
    public void addTelecommunicationBillPayment(int userId, String accountNumber, String telNo, double amount) {
        try {
            BillPayment billPayment = new BillPayment();
            billPayment.setUserId(userId);
            billPayment.setBillType("Telecommunication");
            billPayment.setAmount(amount);
            billPayment.setStatus("Paid");
            billPaymentRepository.save(billPayment);

            TelecommunicationBill telecommunicationBill = new TelecommunicationBill();
            telecommunicationBill.setPaymentId(billPayment.getPaymentId());
            telecommunicationBill.setTelNo(telNo);
            telecommunicationBill.setAmount(amount);
            telecommunicationBillRepository.save(telecommunicationBill);

            Account account = accountRepository.findByAccountNumber(accountNumber);
            if (account == null) {
                throw new IllegalArgumentException("Account not found: " + accountNumber);
            }
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);

            AuditLog auditLog = new AuditLog();
            auditLog.setUserId(userId);
            auditLog.setActionType("Transaction");
            auditLog.setDetails("Telecommunication bill payment of " + amount + " for phone number " + telNo);
            auditLogRepository.save(auditLog);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Insufficient funds for account: " + accountNumber);
        }
    }

    @Transactional
    public void addInsuranceBillPayment(int userId, String accountNumber, String insuranceNo, double amount) {
        try {
            BillPayment billPayment = new BillPayment();
            billPayment.setUserId(userId);
            billPayment.setBillType("Insurance");
            billPayment.setAmount(amount);
            billPayment.setStatus("Paid");
            billPaymentRepository.save(billPayment);

            InsuranceBill insuranceBill = new InsuranceBill();
            insuranceBill.setPaymentId(billPayment.getPaymentId());
            insuranceBill.setInsuranceNo(insuranceNo);
            insuranceBill.setAmount(amount);
            insuranceBillRepository.save(insuranceBill);

            Account account = accountRepository.findByAccountNumber(accountNumber);
            if (account == null) {
                throw new IllegalArgumentException("Account not found: " + accountNumber);
            }
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);

            AuditLog auditLog = new AuditLog();
            auditLog.setUserId(userId);
            auditLog.setActionType("Transaction");
            auditLog.setDetails("Insurance bill payment of " + amount + " for insurance number " + insuranceNo);
            auditLogRepository.save(auditLog);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Insufficient funds for account: " + accountNumber);
        }
    }
}