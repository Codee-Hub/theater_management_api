package com.codehub.theater_management.controller;


import com.codehub.theater_management.model.PaymentMethod;
import com.codehub.theater_management.repository.PaymentMethodRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentsmethods")
@Tag(name = "PaymentMethods", description = "Endpoints para gerenciamento de metodos de Pagamentos")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodRepository repository;

    @PostMapping
    @Operation(summary = "Salvar", description = "Salva metodo de pagamento")
    public PaymentMethod salvar(@RequestBody PaymentMethod paymentMethod) {
        return repository.save(paymentMethod);
    }

    @GetMapping
    @Operation(summary = "Listar", description = "Lista todos os metofod de pagamentos")
    public List<PaymentMethod> listar() {
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar", description = "Deleta metodo de pagamento pelo id")
    public PaymentMethod deletar(@PathVariable Long id) {
        PaymentMethod paymentMethod = repository.findById(id).get();
        repository.delete(paymentMethod);
        return paymentMethod;
    }



}
