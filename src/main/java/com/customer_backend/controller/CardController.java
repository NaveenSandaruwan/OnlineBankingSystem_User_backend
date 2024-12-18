package com.customer_backend.controller;

import com.customer_backend.models.Card;
import com.customer_backend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    // Add a new card
    @PostMapping
    public ResponseEntity<Card> addCard(@RequestBody Card card) {
        Card savedCard = cardService.addCard(card);
        return ResponseEntity.ok(savedCard);
    }

    // Update card details
    @PutMapping("/{cardNumber}")
    public ResponseEntity<Card> updateCard(@PathVariable String cardNumber, @RequestBody Card cardDetails) {
        Optional<Card> cardOptional = cardService.getCardByCardNumber(cardNumber);
        if (cardOptional.isPresent()) {
            Card card = cardOptional.get();
            card.setCardType(cardDetails.getCardType());
            card.setExpiryDate(cardDetails.getExpiryDate());
            card.setCvv(cardDetails.getCvv());
            Card updatedCard = cardService.updateCard(card);
            return ResponseEntity.ok(updatedCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get card details by account number
    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<List<Card>> getCardsByAccountNumber(@PathVariable String accountNumber) {
        List<Card> cards = cardService.getCardsByAccountNumber(accountNumber);
        return ResponseEntity.ok(cards);
    }
}