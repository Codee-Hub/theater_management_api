package com.codehub.theater_management.repository;

import com.codehub.theater_management.model.Spectacle;
import com.codehub.theater_management.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT t FROM Ticket t WHERE t.client.id = :clientId")
    List<Ticket> findTicketsByClientId(@Param("clientId") Long clientId);
}
