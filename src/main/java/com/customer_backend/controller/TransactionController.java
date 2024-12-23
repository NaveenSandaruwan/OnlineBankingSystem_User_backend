package com.customer_backend.controller;

import com.customer_backend.dto.TransactionRequest;
import com.customer_backend.models.Transaction;
import com.customer_backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<String> performTransaction(@RequestBody TransactionRequest request) {
        try {
            transactionService.performTransaction(request.getAccountNumber(), request.getTransactionType(), request.getAmount(), request.getRecipientAccountNumber(), request.getDescription(), request.getRecipientName());
            return ResponseEntity.ok("Transaction successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Transaction failed: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactionsByAccountNumber(@RequestParam String accountNumber) {
        List<Transaction> transactions = transactionService.getTransactionsByAccountNumber(accountNumber);
        return ResponseEntity.ok(transactions);
    }
}