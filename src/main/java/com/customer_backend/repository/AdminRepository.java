package com.customer_backend.repository;

import com.customer_backend.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Custom queries can be added here, for example:
    Admin findByUsername(String username);
}
