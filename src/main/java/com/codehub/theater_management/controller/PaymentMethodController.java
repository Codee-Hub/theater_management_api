package com.codehub.theater_management.controller;


import com.codehub.theater_management.model.PaymentMethod;
import com.codehub.theater_management.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentsmethods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodRepository repository;

    @PostMapping
    public PaymentMethod salvar(@RequestBody PaymentMethod paymentMethod) {
        return repository.save(paymentMethod);
    }

    @GetMapping
    public List<PaymentMethod> listar() {
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    public PaymentMethod deletar(@PathVariable Long id) {
        PaymentMethod paymentMethod = repository.findById(id).get();
        repository.delete(paymentMethod);
        return paymentMethod;
    }



}
