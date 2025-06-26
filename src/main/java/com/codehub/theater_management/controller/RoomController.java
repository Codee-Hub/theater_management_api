package com.codehub.theater_management.controller;

import com.codehub.theater_management.controller.dto.RoomDTO;
import com.codehub.theater_management.controller.dto.TicketDTO;
import com.codehub.theater_management.model.Room;
import com.codehub.theater_management.repository.RoomRepository;
import com.codehub.theater_management.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rooms")
@Tag(name = "Room", description = "Endpoints para gerenciamento de Salas")

public class RoomController {

    @Autowired
    private RoomRepository repository;
    @Autowired
    private RoomService roomService;

    @PostMapping
    @Operation(summary = "Criar", description = "Cria sala")
    public ResponseEntity<Void> salvar(@RequestBody RoomDTO roomDTO, ServletRequest servletRequest) {
        RoomDTO savedRoom = roomService.salvar(roomDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedRoom.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @Operation(summary = "Listar", description = "Lista as salas")
    public ResponseEntity<List<RoomDTO>> listar(
            @PageableDefault(size = 100, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        List<RoomDTO> rooms = roomService.listar(pageable);
        return ResponseEntity.ok(rooms);
    }


}
