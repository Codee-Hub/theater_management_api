package com.codehub.theater_management.controller;

import com.codehub.theater_management.controller.dto.TicketPriceDTO;
import com.codehub.theater_management.model.TicketPrice;
import com.codehub.theater_management.repository.TicketPriceRepository;
import com.codehub.theater_management.service.TicketPriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketsprices")
@Tag(name = "TicketPrice", description = "Endpoints para gerenciamento de Preços dos Tickets")

public class TicketPriceController {

    @Autowired
    TicketPriceService service;

    @Autowired
    TicketPriceRepository repository;

    @PostMapping
    @Operation(summary = "Criar", description = "Cria um ticket com preço e que espetaculo pertence")
    public ResponseEntity<TicketPriceDTO> salvar(@RequestBody TicketPriceDTO dto) {
        try {
            TicketPriceDTO salvo = service.salvar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    @Operation(summary = "Listar", description = "Lista todos tickets")
    public ResponseEntity<List<TicketPriceDTO>> listar() {
        List<TicketPriceDTO> ticketPrices = service.Listar();
        return ResponseEntity.status(HttpStatus.OK).body(ticketPrices);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar", description = "Deleta um preco dado um ticket")
    public TicketPrice deletar(@PathVariable Long id) {
        TicketPrice ticketPrice = repository.findById(id).get();
        repository.delete(ticketPrice);
        return ticketPrice;
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar", description = "Busca um ticket por id")
    public ResponseEntity<TicketPriceDTO> findById(@PathVariable Long id) {
        TicketPriceDTO ticketPrices = service.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketPrices);
    }

}
