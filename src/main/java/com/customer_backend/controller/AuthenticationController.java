package com.customer_backend.controller;

import com.customer_backend.dto.LoginRequest;
import com.customer_backend.dto.UserAccountDTO;
import com.customer_backend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = authenticationService.authenticate(loginRequest);
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @GetMapping("/user-details")
    public ResponseEntity<UserAccountDTO> getUserDetails(@RequestParam String email) {
        UserAccountDTO userAccountDTO = authenticationService.getUserAccountDetails(email);
        if (userAccountDTO != null) {
            return ResponseEntity.ok(userAccountDTO);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}