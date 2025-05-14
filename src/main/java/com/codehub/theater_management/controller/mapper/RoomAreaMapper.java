package com.codehub.theater_management.controller.mapper;

import com.codehub.theater_management.controller.dto.RoomAreaDTO;
import com.codehub.theater_management.model.RoomArea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomAreaMapper {
    default RoomAreaDTO toDTO(RoomArea roomArea) {
        RoomAreaDTO dto = new RoomAreaDTO();
        dto.setId(roomArea.getId());
        dto.setNomeArea(roomArea.getNomeArea());
        dto.setCapacity(roomArea.getCapacity());

        if (roomArea.getRoom() != null) {
            dto.setIdRoom(roomArea.getRoom().getId());
        }

        return dto;
    }

    @Mapping(target = "room", ignore = true)
    default RoomArea toEntity(RoomAreaDTO dto) {
        return null;
    }

}

