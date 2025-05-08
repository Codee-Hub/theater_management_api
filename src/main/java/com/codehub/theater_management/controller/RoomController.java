package com.codehub.theater_management.controller;

import com.codehub.theater_management.controller.dto.RoomDTO;
import com.codehub.theater_management.model.Room;
import com.codehub.theater_management.repository.RoomRepository;
import com.codehub.theater_management.service.RoomService;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomRepository repository;
    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody RoomDTO roomDTO, ServletRequest servletRequest) {
        // Chama o service que salva e retorna o DTO da entidade persistida
        RoomDTO savedRoom = roomService.salvar(roomDTO);

        // Cria a URI com o ID da entidade salva
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedRoom.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public List<Room> listar(){
        return repository.findAll();
    }


}
