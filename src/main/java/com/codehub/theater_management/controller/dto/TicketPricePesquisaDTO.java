package com.codehub.theater_management.controller.dto;

import com.codehub.theater_management.model.PersonType;
import com.codehub.theater_management.model.Spectacle;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(name = "TicketPricePesquisa")
public record TicketPricePesquisaDTO(
        Long id,
        Double price,
        PersonType idPersonType,
        Spectacle idSpectacle
    ) {
}
