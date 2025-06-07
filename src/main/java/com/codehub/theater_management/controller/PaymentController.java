package com.codehub.theater_management.controller;


import com.codehub.theater_management.controller.dto.PaymentDTO;
import com.codehub.theater_management.repository.PaymentRepository;
import com.codehub.theater_management.service.PaymentService;
import com.codehub.theater_management.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@Tag(name = "Payments", description = "Endpoints para gerenciamento de Pagamentos")
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private PaymentService service;

    @PostMapping
    @Operation(summary = "Salvar", description = "Salva Pagamento")
    public ResponseEntity<PaymentDTO> salvar(@RequestBody PaymentDTO paymentDTO) {
        try {
            PaymentDTO salvo = service.salvar(paymentDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
