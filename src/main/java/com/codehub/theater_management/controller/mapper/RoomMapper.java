package com.codehub.theater_management.controller.mapper;

import com.codehub.theater_management.controller.dto.RoomDTO;
import com.codehub.theater_management.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    default RoomDTO toDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setCapacity(room.getCapacity());

        if (room.getTheater() != null){
            dto.setIdTheater(room.getTheater().getId());
        }
        return dto;
    }
    @Mapping(target = "theater", ignore = true)
    default Room toEntity(RoomDTO dto) {
        return null;
    }

}
