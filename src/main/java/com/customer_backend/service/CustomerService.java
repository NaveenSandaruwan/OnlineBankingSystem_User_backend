package com.customer_backend.service;

import com.customer_backend.models.User;
import com.customer_backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Create or update a customer
    public User saveCustomer(User customer) {
        return customerRepository.save(customer);
    }

    // Get all customers
    public List<User> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by ID
    public Optional<User> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Get customer by email
    public User getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email).orElse(null);
    }

    // Delete customer by ID
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
