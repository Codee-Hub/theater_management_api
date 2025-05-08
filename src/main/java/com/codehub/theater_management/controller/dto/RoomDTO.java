package com.codehub.theater_management.controller.dto;

import lombok.Data;

@Data
public class RoomDTO {

    private Long id;
    private Integer roomNumber;
    private Integer capacity;
    private Long idTheater;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Long getIdTheater() {
        return idTheater;
    }

    public void setIdTheater(Long idTheater) {
        this.idTheater = idTheater;
    }
}
