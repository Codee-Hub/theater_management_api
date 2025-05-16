package com.codehub.theater_management.controller.mapper;


import com.codehub.theater_management.controller.dto.SpectacleDTO;
import com.codehub.theater_management.model.Spectacle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SpectacleMapper {

    @Mapping(source = "room.id", target = "idRoom")
    SpectacleDTO toDTO(Spectacle entity);

    @Mapping(target = "room", ignore = true) // O campo será setado manualmente no service
    Spectacle toEntity(SpectacleDTO dto);
}

