package com.codehub.theater_management.service;

import com.codehub.theater_management.controller.dto.ArmchairDTO;
import com.codehub.theater_management.controller.mapper.ArmchairMapper;
import com.codehub.theater_management.model.Armchair;
import com.codehub.theater_management.model.RoomArea;
import com.codehub.theater_management.repository.ArmchairRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArmchairService {

    @Autowired
    public ArmchairRepository repository;

    @Autowired
    public ArmchairMapper armchairMapper;

    public ArmchairDTO salvar(ArmchairDTO armchairDTO) {
        Armchair armchair = armchairMapper.toEntity(armchairDTO);

        // Buscar a RoomArea correspondente ao idRoomArea informado
        RoomArea roomArea = repository.findById(armchairDTO.getIdRoomArea())
                .orElseThrow(() -> new RuntimeException("RoomArea não encontrada com ID: " + armchairDTO.getIdRoomArea())).getRoomArea();

        // Associar a RoomArea na cadeira
        armchair.setRoomArea(roomArea);

        // Salvar no banco
        Armchair saved = repository.save(armchair);

        // Retornar DTO com os dados salvos
        return armchairMapper.toDTO(saved);
    }

    public @NotNull List<ArmchairDTO> listar() {
        return repository.findAll()
                .stream()
                .map(ArmchairDTO::new) // Supondo que ArmchairDTO tem um construtor que aceita Armchair
                .collect(Collectors.toList());
    }


}
