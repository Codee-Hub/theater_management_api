package com.codehub.theater_management.service;

import com.codehub.theater_management.model.Ticket;
import com.codehub.theater_management.repository.TicketRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    public List<Ticket> listar() {
        return repository.findAll();
    }

}
