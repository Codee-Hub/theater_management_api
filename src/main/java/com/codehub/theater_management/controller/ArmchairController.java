package com.codehub.theater_management.controller;

import com.codehub.theater_management.controller.dto.ArmchairDTO;
import com.codehub.theater_management.model.Armchair;
import com.codehub.theater_management.repository.ArmchairRepository;
import com.codehub.theater_management.service.ArmchairService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armchairs")
@Tag(name = "Armchairs", description = "Endpoints para gerenciamento de Cadeiras")
public class ArmchairController {

    @Autowired
    public ArmchairRepository repository;

    @Autowired
    public ArmchairService armchairService;

    @PostMapping
    @Operation(summary = "Criar", description = "Criar Cadeira")
    public ResponseEntity<ArmchairDTO> salvar(@RequestBody ArmchairDTO armchairDTO) {
        try {
            ArmchairDTO salvo = armchairService.salvar(armchairDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/by-room/{roomId}")
    @Operation(summary = "Listar", description = "Obtem todas as poltronas associadas a uma determinada sala")
    public ResponseEntity<List<Armchair>> getByRoom(@PathVariable Long roomId) {
        List<Armchair> armchairs = armchairService.buscarPoltronasPorSala(roomId);
        return ResponseEntity.ok(armchairs);
    }

    @GetMapping
    @Operation(summary = "Listar", description = "Listar cadeiras")
    public ResponseEntity<List<ArmchairDTO>> listarTodos(
            @PageableDefault(size = 100, sort = "id", direction = Sort.Direction.ASC)Pageable pageable) {
        List<ArmchairDTO> armchairs = armchairService.listar(pageable); //.subList(0, 100) Postman limita usar para teste
        return ResponseEntity.ok(armchairs);
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar", description = "Busca cadeiras pelo id")
    public ResponseEntity<Armchair> findById(@PathVariable Long id) {
        Armchair armchair = repository.findById(id).get();
        return ResponseEntity.ok(armchair);
    }

    // isdudufd

}
