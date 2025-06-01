package com.codehub.theater_management.controller.dto;

import com.codehub.theater_management.model.PaymentMethod;
import com.codehub.theater_management.model.Ticket;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(name = "PaymentPesquisa")
public record PaymentPesquisaDTO (

        Long id,
        Double price,
        Integer status,
        PaymentMethod paymentMethodId,
        Ticket ticketId

    ){
}
