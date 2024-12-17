package com.customer_backend.service;

import com.customer_backend.models.Admin;
import com.customer_backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Create or update an admin
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Get admin by username
    public Admin getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    // Get admin by ID
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    // Delete admin by ID
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
