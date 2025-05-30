package com.codehub.theater_management.repository;

import com.codehub.theater_management.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
