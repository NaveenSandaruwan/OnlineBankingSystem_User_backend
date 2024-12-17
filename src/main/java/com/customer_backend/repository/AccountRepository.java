package com.customer_backend.repository;

import com.customer_backend.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Add custom query methods if needed

    Account findByAccountNumber(String accountNumber);

}

