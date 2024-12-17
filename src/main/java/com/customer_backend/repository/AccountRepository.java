package com.customer_backend.repository;

import com.customer_backend.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNumber(String accountNumber);
    List<Account> findByUserId(Long userId);
    Optional<Account> findByAccountNumberAndUserId(String accountNumber, Long userId);
    // Optional<Account> findByAccountNumber(String accountNumber); // Removed duplicate method
}