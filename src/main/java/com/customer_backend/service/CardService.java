package com.customer_backend.service;

import com.customer_backend.models.Card;
import com.customer_backend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    public Card updateCard(Card card) {
        return cardRepository.save(card);
    }

    public Optional<Card> getCardByCardNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }

    public List<Card> getCardsByAccountNumber(String accountNumber) {
        return cardRepository.findByAccountNumber(accountNumber);
    }
}