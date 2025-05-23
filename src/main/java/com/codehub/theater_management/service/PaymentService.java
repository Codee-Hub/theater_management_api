package com.codehub.theater_management.service;

import com.codehub.theater_management.controller.dto.PaymentDTO;
import com.codehub.theater_management.controller.mapper.PaymentMapper;
import com.codehub.theater_management.model.Payment;
import com.codehub.theater_management.model.PaymentMethod;
import com.codehub.theater_management.model.Ticket;
import com.codehub.theater_management.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private PaymentMapper mapper;

    public PaymentDTO salvar(PaymentDTO paymentDTO) {
        Payment payment = mapper.toEntity(paymentDTO);

        PaymentMethod paymentMethod = repository.findById(paymentDTO.getPaymentMethodId())
                .orElseThrow(()-> new RuntimeException("Metodo de pagamento nao encontrado Nao encontrado" + paymentDTO.getPaymentMethodId())).getPaymentMethod();


        Ticket ticket = repository.findById(paymentDTO.getTicketId())
                .orElseThrow(()-> new RuntimeException("Spectale Nao encontrado" + paymentDTO.getTicketId())).getTicket();


        payment.setPaymentMethod(paymentMethod);
        payment.setTicket(ticket);

        Payment salvar = repository.save(payment);
        return mapper.toDTO(salvar);
    }


}
