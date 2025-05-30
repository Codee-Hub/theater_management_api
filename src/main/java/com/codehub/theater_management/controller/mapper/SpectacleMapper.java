package com.codehub.theater_management.controller.mapper;

import com.codehub.theater_management.controller.dto.SpectacleDTO;
import com.codehub.theater_management.model.Room;
import com.codehub.theater_management.model.Spectacle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpectacleMapper {
    default SpectacleDTO toDTO(Spectacle entity){
        SpectacleDTO dto = new SpectacleDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setNome(entity.getNome());
        dto.setDuration(entity.getDuration());

        if (entity.getRoom() != null){
            dto.setIdRoom(entity.getRoom().getId());
        }
        return dto;
    }

    default Spectacle toEntity(SpectacleDTO dto){
        if (dto == null){
            return null;
        }

        Spectacle spectacle = new Spectacle();
        spectacle.setId(dto.getId());
        spectacle.setDate(dto.getDate());
        spectacle.setNome(dto.getNome());
        spectacle.setDuration(dto.getDuration());

        if (dto.getIdRoom() != null){
            Room room = new Room();
            room.setId(dto.getIdRoom());
            spectacle.setRoom(room);
        }
        return spectacle;
    }
}
