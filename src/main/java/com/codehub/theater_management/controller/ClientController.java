package com.codehub.theater_management.controller;


import com.codehub.theater_management.controller.dto.ClientDTO; // Importar ClientDTO
import com.codehub.theater_management.model.Client;
import com.codehub.theater_management.repository.ClientRepository;
import com.codehub.theater_management.service.ClientService; // Usar ClientService
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable; // Importar Pageable
import org.springframework.data.domain.Sort;    // Importar Sort
import org.springframework.data.web.PageableDefault; // Importar PageableDefault
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Client", description = "Endpoints para gerenciamento de Clientes")
public class ClientController {

    @Autowired
    public ClientRepository repository;
    @Autowired
    private ClientService service;


    @PostMapping
    @Operation(summary = "Criar", description = "Criar Cliente")
    public Client salvar(@RequestBody Client client) {
        return repository.save(client);
    }

    @GetMapping
    @Operation(summary = "Listar", description = "Lista todos Clientes com paginação")
    public ResponseEntity<List<ClientDTO>> listar(
            @PageableDefault(size = 100, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        List<ClientDTO> clients = service.listar(pageable);
        return ResponseEntity.ok(clients);
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
