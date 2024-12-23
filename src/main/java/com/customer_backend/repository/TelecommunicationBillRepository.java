package com.customer_backend.repository;

import com.customer_backend.models.TelecommunicationBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelecommunicationBillRepository extends JpaRepository<TelecommunicationBill, Integer> {
}