package com.codehub.theater_management.controller.dto;

import com.codehub.theater_management.model.Armchair;
import com.codehub.theater_management.model.Client;
import com.codehub.theater_management.model.Spectacle;
import com.codehub.theater_management.model.TicketPrice;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "TicketPesquisa")
public record TicketPesquisaDTO (

        Long id,
        Spectacle spectacleId,
        Client clientId,
        Armchair armchairId,
        TicketPrice ticketPriceId
    ){
}
