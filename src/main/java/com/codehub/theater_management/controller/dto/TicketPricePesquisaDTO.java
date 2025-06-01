package com.codehub.theater_management.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(name = "TicketPricePesquisa")
public record TicketPricePesquisaDTO(
        Long id,
        Double price,
        Long idPersonType,
        Long idSpectacle
) {
}
