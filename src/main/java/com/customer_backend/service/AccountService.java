package com.customer_backend.service;

import com.customer_backend.models.Account;
import com.customer_backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Create or update an account
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Get account by account number
    public Account getAccountByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    // Get account by ID
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    // Delete account by ID
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
    
}
