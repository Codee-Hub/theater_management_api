package com.codehub.theater_management.controller.mapper;

import com.codehub.theater_management.controller.dto.TicketPriceDTO;
import com.codehub.theater_management.model.PersonType;
import com.codehub.theater_management.model.Spectacle;
import com.codehub.theater_management.model.TicketPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TicketPriceMapper {
    default TicketPriceDTO toDTO(TicketPrice entity) {
        TicketPriceDTO dto = new TicketPriceDTO();
        dto.setId(entity.getId());
        dto.setPrice(entity.getPrice());

        if (entity.getSpectacle() != null && (entity.getSpectacle() != null)){
            dto.setIdSpectacle(entity.getSpectacle().getId());
            dto.setIdPersonType(entity.getPersonType().getId());
        }
        return dto;
    }

    // Implementação do toEntity
    default TicketPrice toEntity(TicketPriceDTO dto) {
        if (dto == null) {
            return null;
        }

        TicketPrice entity = new TicketPrice();
        entity.setId(dto.getId());
        entity.setPrice(dto.getPrice());

        if (dto.getIdSpectacle() != null) {
            Spectacle spectacle = new Spectacle();
            spectacle.setId(dto.getIdSpectacle());
            entity.setSpectacle(spectacle);
        }

        if (dto.getIdPersonType() != null) {
            PersonType personType = new PersonType();
            personType.setId(dto.getIdPersonType());
            entity.setPersonType(personType);
        }

        return entity;
    }

}

