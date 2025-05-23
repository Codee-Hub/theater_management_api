package com.codehub.theater_management.controller;

import com.codehub.theater_management.model.Ticket;
import com.codehub.theater_management.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    TicketRepository repository;

    @GetMapping
    public List<Ticket> listar() {
        return repository.findAll().subList(0, 100);
    }


}
