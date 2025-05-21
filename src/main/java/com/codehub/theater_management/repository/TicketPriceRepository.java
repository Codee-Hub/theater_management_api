package com.codehub.theater_management.repository;

import com.codehub.theater_management.model.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketPriceRepository extends JpaRepository<TicketPrice, Long> {
}
