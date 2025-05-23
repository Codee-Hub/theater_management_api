package com.codehub.theater_management.repository;

import com.codehub.theater_management.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
