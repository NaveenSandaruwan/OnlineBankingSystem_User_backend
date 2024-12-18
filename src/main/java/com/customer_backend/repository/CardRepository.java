package com.customer_backend.repository;

import com.customer_backend.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findByAccountNumber(String accountNumber);
    Optional<Card> findByCardNumber(String cardNumber);
}