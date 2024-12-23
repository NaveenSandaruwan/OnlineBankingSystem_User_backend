package com.customer_backend.controller;

import com.customer_backend.dto.*;
import com.customer_backend.service.BillPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bill-payments")
public class BillPaymentController {

    @Autowired
    private BillPaymentService billPaymentService;

    @PostMapping("/electricity")
    public ResponseEntity<String> addElectricityBillPayment(@RequestBody ElectricityBillPaymentRequest request) {
        try {
            billPaymentService.addElectricityBillPayment(request.getUserId(), request.getAccountNumber(), request.getElectricityAccountNo(), request.getAmount());
            return ResponseEntity.ok("Electricity bill payment successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/water")
    public ResponseEntity<String> addWaterBillPayment(@RequestBody WaterBillPaymentRequest request) {
        try {
            billPaymentService.addWaterBillPayment(request.getUserId(), request.getAccountNumber(), request.getWaterAccountNo(), request.getAmount());
            return ResponseEntity.ok("Water bill payment successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/telecommunication")
    public ResponseEntity<String> addTelecommunicationBillPayment(@RequestBody TelecommunicationBillPaymentRequest request) {
        try {
            billPaymentService.addTelecommunicationBillPayment(request.getUserId(), request.getAccountNumber(), request.getTelNo(), request.getAmount());
            return ResponseEntity.ok("Telecommunication bill payment successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/insurance")
    public ResponseEntity<String> addInsuranceBillPayment(@RequestBody InsuranceBillPaymentRequest request) {
        try {
            billPaymentService.addInsuranceBillPayment(request.getUserId(), request.getAccountNumber(), request.getInsuranceNo(), request.getAmount());
            return ResponseEntity.ok("Insurance bill payment successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}