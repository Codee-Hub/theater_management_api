package com.codehub.theater_management.controller;

import com.codehub.theater_management.controller.dto.TicketPriceDTO;
import com.codehub.theater_management.model.TicketPrice;
import com.codehub.theater_management.repository.TicketPriceRepository;
import com.codehub.theater_management.service.TicketPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketsprices")
public class TicketPriceController {

    @Autowired
    TicketPriceService service;

    @Autowired
    TicketPriceRepository repository;

    @PostMapping
    public ResponseEntity<TicketPriceDTO> salvar(@RequestBody TicketPriceDTO dto) {
        try {
            TicketPriceDTO salvo = service.salvar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<TicketPriceDTO>> listar() {
        List<TicketPriceDTO> ticketPrices = service.Listar();
        return ResponseEntity.status(HttpStatus.OK).body(ticketPrices);
    }

    @DeleteMapping("{id}")
    public TicketPrice deletar(@PathVariable Long id) {
        TicketPrice ticketPrice = repository.findById(id).get();
        repository.delete(ticketPrice);
        return ticketPrice;
    }

}
