package com.codehub.theater_management.controller.mapper;

import com.codehub.theater_management.controller.dto.ArmchairDTO;
import com.codehub.theater_management.model.Armchair;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArmchairMapper {
    default ArmchairDTO toDTO(Armchair armchair) {
        ArmchairDTO dto = new ArmchairDTO();
        dto.setId(armchair.getId());
        dto.setNumero(armchair.getNumero());

        if (armchair.getRoomArea() != null) {
            dto.setIdRoomArea(armchair.getRoomArea().getId());
        }
        return dto;
    }

    @Mapping(target = "roomArea", ignore = true)
    Armchair toEntity(ArmchairDTO dto);
}
