package com.codehub.theater_management.controller;


import com.codehub.theater_management.model.Client;
import com.codehub.theater_management.repository.ClientRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
@Tag(name = "Client", description = "Endpoints para gerenciamento de Clientes")
public class ClientController {

    @Autowired
    public ClientRepository repository;


    @PostMapping
    @Operation(summary = "Criar", description = "Criar Cliente")
    public Client salvar(@RequestBody Client client) {
        return repository.save(client);
    }

    @GetMapping
    @Operation(summary = "Listar", description = "Lista todos Clientes")
    public List<Client> listar() {
        return repository.findAll(); //.subList(0, 100) Postman limita usar para teste
    }

    @GetMapping("{email}")
    @Operation(summary = "Buscar", description = "Busca cliente pelo email")
    public Client deletar(@PathVariable String email) {
        return repository.findByEmail(email).get();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar", description = "Deleta cliente pelo id")
    public Client deletar(@PathVariable Long id) {
        Client client = repository.findById(id).get();
        repository.delete(client);
        return client;
    }



}
