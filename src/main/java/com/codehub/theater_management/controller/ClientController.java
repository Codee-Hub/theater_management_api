package com.codehub.theater_management.controller;


import com.codehub.theater_management.model.Client;
import com.codehub.theater_management.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        return repository.findAll(); //.subList(0, 100) Postman limita usar para teste
    }

    @GetMapping("{email}")
    public Client deletar(@PathVariable String email) {
        return repository.findByEmail(email).get();
    }

    @DeleteMapping("{id}")
    public Client deletar(@PathVariable Long id) {
        Client client = repository.findById(id).get();
        repository.delete(client);
        return client;
    }



}
