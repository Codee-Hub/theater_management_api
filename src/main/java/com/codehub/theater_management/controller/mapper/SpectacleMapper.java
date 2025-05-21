package com.codehub.theater_management.controller.mapper;


import com.codehub.theater_management.controller.dto.RoomDTO;
import com.codehub.theater_management.controller.dto.SpectacleDTO;
import com.codehub.theater_management.model.Spectacle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SpectacleMapper {
    default SpectacleDTO toDTO(Spectacle entity){
        SpectacleDTO dto = new SpectacleDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setDuration(entity.getDuration());

        if (entity.getRoom() != null){
            dto.setIdRoom(entity.getRoom().getId());
        }
        return dto;
    }

    @Mapping(target = "room", ignore = true) // O campo será setado manualmente no service
    Spectacle toEntity(SpectacleDTO dto);
}

