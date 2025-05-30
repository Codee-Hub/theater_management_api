package com.codehub.theater_management.controller.mapper;

import com.codehub.theater_management.controller.dto.TicketDTO;
import com.codehub.theater_management.model.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class TicketMapper {
    public TicketDTO toDTO(Ticket entity){
        TicketDTO dto = new TicketDTO();
        dto.setId(entity.getId());

        if (entity.getSpectacle() != null && (entity.getClient()  != null)
                && (entity.getArmchair() != null) && (entity.getTicketPrice()!= null)) {
            dto.setSpectacleId(entity.getSpectacle().getId());
            dto.setClientId(entity.getClient().getId());
            dto.setArmchairId(entity.getArmchair().getId());
            dto.setTicketPriceId(entity.getTicketPrice().getId());
        }
        return dto;
    }

    public Ticket toEntity(TicketDTO dto){
        if (dto == null) {
            return null;
        }
        Ticket entity = new Ticket();
        entity.setId(dto.getId());
        if (dto.getSpectacleId() != null) {
            Spectacle spectacle = new Spectacle();
            spectacle.setId(dto.getSpectacleId());
            entity.setSpectacle(spectacle);
        }
        if (dto.getClientId() != null) {
            Client client = new Client();
            client.setId(dto.getClientId());
            entity.setClient(client);
        }
        if (dto.getArmchairId() != null) {
            Armchair armchair = new Armchair();
            armchair.setId(dto.getArmchairId());
            entity.setArmchair(armchair);
        }
        if (dto.getTicketPriceId() != null) {
            TicketPrice ticketPrice = new TicketPrice();
            ticketPrice.setId(dto.getTicketPriceId());
            entity.setTicketPrice(ticketPrice);
        }
        return entity;
    }



}
