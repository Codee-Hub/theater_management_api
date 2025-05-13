package com.codehub.theater_management.controller;

import com.codehub.theater_management.controller.dto.RoomAreaDTO;
import com.codehub.theater_management.model.RoomArea;
import com.codehub.theater_management.repository.RoomAreaRepository;
import com.codehub.theater_management.service.RoomAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomareas")
public class RoomAreaController {

    @Autowired
    public RoomAreaRepository RoomAreaRepository;

    @Autowired
    RoomAreaService roomAreaService;

    @PostMapping
    public ResponseEntity<RoomArea> salvar(@RequestBody RoomAreaDTO dto) {
        RoomArea roomArea = roomAreaService.salvar(dto);
        return ResponseEntity.ok(roomArea);
    }
    @GetMapping
    public List<RoomArea> listar() {
        return RoomAreaRepository.findAll();
    }


}
