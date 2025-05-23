package com.codehub.theater_management.service;

import com.codehub.theater_management.model.PaymentMethod;
import com.codehub.theater_management.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;

@Service
public class PaymentMethodService {

    @Autowired
    public PaymentMethodRepository repository;


    public PaymentMethod salvar(PaymentMethod paymentMethod) {
        return repository.save(paymentMethod);
    }

    public List<PaymentMethod> listar() {
        return repository.findAll();
    }

    public PaymentMethod delete(PaymentMethod paymentMethod) {
        repository.delete(paymentMethod);
        return paymentMethod;
    }

}
