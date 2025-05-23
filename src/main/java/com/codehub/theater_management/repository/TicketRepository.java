package com.codehub.theater_management.repository;

import com.codehub.theater_management.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
