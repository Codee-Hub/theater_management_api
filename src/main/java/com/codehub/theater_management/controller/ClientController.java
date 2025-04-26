package com.codehub.theater_management.controller;


import com.codehub.theater_management.model.Client;
import com.codehub.theater_management.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    public ClientRepository repository;

    @PostMapping
    public Client salvar(@RequestBody Client client) {
        return repository.save(client);
    }

    @GetMapping
    public List<Client> listar() {
        return repository.findAll();
    }



}
