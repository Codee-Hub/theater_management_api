package com.codehub.theater_management.controller.dto;

import com.codehub.theater_management.model.Armchair;
import lombok.Data;

@Data
public class ArmchairDTO {

    private Long id;
    private Integer numero;
    private Long idRoomArea;

    public ArmchairDTO(Armchair armchair) {
        this.id = armchair.getId();
        this.numero = armchair.getNumero();
    }

    public ArmchairDTO() {

    }
}
