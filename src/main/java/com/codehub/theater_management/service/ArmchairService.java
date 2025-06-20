package com.codehub.theater_management.service;

import com.codehub.theater_management.controller.dto.ArmchairDTO;
import com.codehub.theater_management.controller.mapper.ArmchairMapper;
import com.codehub.theater_management.model.Armchair;
import com.codehub.theater_management.model.RoomArea;
import com.codehub.theater_management.repository.ArmchairRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArmchairService {

    @Autowired
    public ArmchairRepository repository;

    @Autowired
    public ArmchairMapper armchairMapper;

    public List<Armchair> buscarPoltronasPorSala(Long idSala) {
        return repository.findAllByRoomId(idSala);
    }

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

    public List<ArmchairDTO> listar(Pageable pageable) {
        Page<Armchair> armchairsPage = repository.findAll(pageable);
        return armchairsPage.map(armchairMapper::toDTO).getContent();
    }


}
