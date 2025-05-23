package com.codehub.theater_management.controller;

import com.codehub.theater_management.controller.dto.ArmchairDTO;
import com.codehub.theater_management.repository.ArmchairRepository;
import com.codehub.theater_management.service.ArmchairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armchairs")
public class ArmchairController {

    @Autowired
    public ArmchairRepository repository;

    @Autowired
    public ArmchairService armchairService;

    @PostMapping
    public ResponseEntity<ArmchairDTO> salvar(@RequestBody ArmchairDTO armchairDTO) {
        try {
            ArmchairDTO salvo = armchairService.salvar(armchairDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @GetMapping
    public ResponseEntity<List<ArmchairDTO>> listarTodos() {
        List<ArmchairDTO> armchairs = armchairService.listar(); //.subList(0, 100) Postman limita usar para teste
        return ResponseEntity.ok(armchairs);
    }



}
