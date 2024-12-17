package com.customer_backend.repository;

import com.customer_backend.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Custom queries can be added here, for example:
    List<Transaction> findByAccountId(Long accountId);
}
