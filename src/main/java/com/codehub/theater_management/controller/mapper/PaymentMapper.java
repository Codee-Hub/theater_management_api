package com.codehub.theater_management.controller.mapper;

import com.codehub.theater_management.controller.dto.PaymentDTO;
import com.codehub.theater_management.model.Payment;
import com.codehub.theater_management.model.PaymentMethod;
import com.codehub.theater_management.model.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    default PaymentDTO toDTO(Payment entity) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(entity.getId());
        dto.setPrice(entity.getPrice());
        dto.setStatus(entity.getStatus());

        if (entity.getPaymentMethod() != null && (entity.getTicket().getId() != null)) {
            dto.setPaymentMethodId(entity.getPaymentMethod().getId());
            dto.setTicketId(entity.getTicket().getId());
        }
        return dto;
    }


    default Payment toEntity(PaymentDTO dto) {
        if (dto == null) {
            return null;
        }

        Payment entity = new Payment();
        entity.setId(dto.getId());
        entity.setPrice(dto.getPrice());
        entity.setStatus(dto.getStatus());

        if (dto.getPaymentMethodId() != null) {
            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setId(dto.getPaymentMethodId());
            entity.setPaymentMethod(paymentMethod);
        }

        if (dto.getTicketId() != null) {
            Ticket ticket = new Ticket();
            ticket.setId(dto.getTicketId());
            entity.setTicket(ticket);
        }
        return entity;
    }


}
