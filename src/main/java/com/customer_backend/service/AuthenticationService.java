package com.customer_backend.service;

import com.customer_backend.dto.LoginRequest;
import com.customer_backend.dto.UserAccountDTO;
import com.customer_backend.models.Account;
import com.customer_backend.models.User;
import com.customer_backend.repository.AccountRepository;
import com.customer_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    public boolean authenticate(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Optional<Account> accountOptional = accountRepository.findByAccountNumberAndUserId(loginRequest.getAccountNumber(), user.getId().intValue());
            if (accountOptional.isPresent() && user.getPasswordHash().equals(loginRequest.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public UserAccountDTO getUserAccountDetails(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            UserAccountDTO userAccountDTO = new UserAccountDTO();
            userAccountDTO.setUserId(user.getId().intValue());
            userAccountDTO.setFirstName(user.getFirstName());
            userAccountDTO.setLastName(user.getLastName());
            userAccountDTO.setPhone(user.getPhone());
            userAccountDTO.setAddress(user.getAddress());

            return userAccountDTO;
        }
        return null;
    }
}