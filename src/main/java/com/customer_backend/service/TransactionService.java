package com.customer_backend.service;

import com.customer_backend.models.Account;
import com.customer_backend.models.AuditLog;
import com.customer_backend.models.Transaction;
import com.customer_backend.repository.AccountRepository;
import com.customer_backend.repository.AuditLogRepository;
import com.customer_backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TransactionService {

    private static final Logger logger = Logger.getLogger(TransactionService.class.getName());

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Transactional(rollbackFor = Exception.class)
    public void performTransaction(String accountNumber, String transactionType, double amount, String recipientAccountNumber, String description, String recipientName) {
        try {
            // Ensure accountNumber is not null
            if (accountNumber == null || accountNumber.isEmpty()) {
                throw new IllegalArgumentException("Account number cannot be null or empty");
            }

            // Create a new transaction
            Transaction transaction = new Transaction();
            transaction.setAccountNumber(accountNumber);
            transaction.setTransactionType(transactionType);
            transaction.setAmount(amount);
            transaction.setRecipientAccountNumber(recipientAccountNumber);
            transaction.setDescription(description);
            transaction.setRecipientName(recipientName);
            transactionRepository.save(transaction);

            // Find the account by account number
            Account account = accountRepository.findByAccountNumber(accountNumber);
            if (account == null) {
                throw new IllegalArgumentException("Account not found: " + accountNumber);
            }

            // Update the account balance based on the transaction type
            if (transactionType.equals("Deposit")) {
                account.setBalance(account.getBalance() + amount);
            } else if (transactionType.equals("Withdrawal")) {
                account.setBalance(account.getBalance() - amount);
            } else if (transactionType.equals("Transfer") && recipientAccountNumber != null) {
                if (account.getBalance() < amount) {
                    throw new IllegalArgumentException("Insufficient funds for account: " + accountNumber);
                }
                account.setBalance(account.getBalance() - amount);
                // Find the recipient account by account number
                Account recipientAccount = accountRepository.findByAccountNumber(recipientAccountNumber);
                if (recipientAccount == null) {
                    throw new IllegalArgumentException("Recipient account not found: " + recipientAccountNumber);
                }
                recipientAccount.setBalance(recipientAccount.getBalance() + amount);
                accountRepository.save(recipientAccount);
            }
            accountRepository.save(account);

            // Create an audit log
            AuditLog auditLog = new AuditLog();
            auditLog.setUserId(account.getUserId());
            auditLog.setActionType("Transaction");
            auditLog.setDetails("Performed " + transactionType + " of " + amount + " on account " + accountNumber);
            auditLogRepository.save(auditLog);
        } catch (Exception e) {
            logger.severe("Transaction failed: " + e.getMessage());
            throw e; // This will trigger the transaction rollback
        }
    }

    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }
}