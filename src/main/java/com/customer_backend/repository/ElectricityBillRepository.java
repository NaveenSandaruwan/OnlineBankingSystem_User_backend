package com.customer_backend.repository;

import com.customer_backend.models.ElectricityBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricityBillRepository extends JpaRepository<ElectricityBill, Integer> {
}