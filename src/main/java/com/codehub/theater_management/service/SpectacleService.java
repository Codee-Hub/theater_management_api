package com.codehub.theater_management.service;

import com.codehub.theater_management.controller.dto.ArmchairDTO;
import com.codehub.theater_management.controller.dto.RoomDTO;
import com.codehub.theater_management.controller.dto.SpectacleDTO;
import com.codehub.theater_management.controller.mapper.SpectacleMapper;
import com.codehub.theater_management.model.Client;
import com.codehub.theater_management.model.Room;
import com.codehub.theater_management.model.Spectacle;
import com.codehub.theater_management.model.Theater;
import com.codehub.theater_management.repository.ClientRepository;
import com.codehub.theater_management.repository.RoomRepository;
import com.codehub.theater_management.repository.SpectacleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpectacleService {

    @Autowired
    private SpectacleRepository repository;

    @Autowired
    private SpectacleMapper spectacleMapper;

    @Autowired
    private RoomRepository roomRepository;


    public SpectacleDTO salvar(SpectacleDTO spectacleDTO) {
        Spectacle spectacle = spectacleMapper.toEntity(spectacleDTO);

        System.out.println(spectacleDTO.getPrecoBase());

        Room room = roomRepository.findById(spectacleDTO.getIdRoom())
                .orElseThrow(() -> new RuntimeException("Room não encontrada com ID: " + spectacleDTO.getIdRoom()));

        spectacle.setRoom(room);

        System.out.println(spectacle.getPrecoBase());

        Spectacle savedSpec = repository.save(spectacle);

        return spectacleMapper.toDTO(savedSpec);

    }

    public List<SpectacleDTO> listar(Pageable pageable) {
        return repository.findAll(pageable)
                .map(spectacleMapper::toDTO)
                .getContent();
    }

    public Spectacle deletar(Spectacle  spectacle) {
        repository.delete(spectacle);
        return spectacle;
    }


}
