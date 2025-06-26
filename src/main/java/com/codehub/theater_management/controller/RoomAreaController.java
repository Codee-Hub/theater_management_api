package com.codehub.theater_management.controller;

import com.codehub.theater_management.controller.dto.RoomAreaDTO;
import com.codehub.theater_management.model.RoomArea;
import com.codehub.theater_management.repository.RoomAreaRepository;
import com.codehub.theater_management.service.RoomAreaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomareas")
@Tag(name = "RoomArea", description = "Endpoints para gerenciamento de Areas. vip, normal, camarote ")
public class RoomAreaController {

    @Autowired
    public RoomAreaRepository RoomAreaRepository;

    @Autowired
    RoomAreaService roomAreaService;

    @PostMapping
    @Operation(summary = "Salvar", description = "Salva Areas das salas")
    public ResponseEntity<RoomArea> salvar(@RequestBody RoomAreaDTO dto) {
        RoomArea roomArea = roomAreaService.salvar(dto);
        return ResponseEntity.ok(roomArea);
    }
    @GetMapping
    @Operation(summary = "Listar", description = "Lista as Areas das salas")
    public ResponseEntity<List<RoomArea>> listar(
            @PageableDefault(size = 100, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        List<RoomAreaDTO> roomAreas = roomAreaService.listar(pageable);
        return ResponseEntity.ok(roomAreas);
    }




}
