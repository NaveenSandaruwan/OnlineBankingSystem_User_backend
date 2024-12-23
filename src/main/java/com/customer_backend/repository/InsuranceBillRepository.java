package com.customer_backend.repository;

import com.customer_backend.models.InsuranceBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceBillRepository extends JpaRepository<InsuranceBill, Integer> {
}