package com.codehub.theater_management.service;

import com.codehub.theater_management.controller.dto.RoomAreaDTO;
import com.codehub.theater_management.model.Room;
import com.codehub.theater_management.model.RoomArea;
import com.codehub.theater_management.repository.RoomAreaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAreaService {

    @Autowired
    RoomAreaRepository repository;

    public RoomArea salvar(RoomAreaDTO dto) {
        RoomArea roomArea = new RoomArea();
        roomArea.setId(dto.getId());
        roomArea.setNomeArea(dto.getNomeArea());
        roomArea.setCapacity(dto.getCapacity());

        // Aqui associamos a Room
        Room room = repository.findById(dto.getIdRoom())
                .orElseThrow(() -> new RuntimeException("Room não encontrada com ID: " + dto.getIdRoom())).getRoom();
        roomArea.setRoom(room);

        return repository.save(roomArea);
    }


    public List<RoomArea> listar() {
        return repository.findAll();
    }

    public RoomArea findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("RoomArea not found with id: " + id));
    }

}
