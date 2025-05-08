package com.codehub.theater_management.controller.mapper;

import com.codehub.theater_management.controller.dto.RoomDTO;
import com.codehub.theater_management.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    @Mapping(source = "theater.id", target = "idTheater")
    RoomDTO toDTO(Room room);

    @Mapping(target = "theater", ignore = true)
    Room toEntity(RoomDTO dto);

}
