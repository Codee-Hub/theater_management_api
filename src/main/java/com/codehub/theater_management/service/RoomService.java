package com.codehub.theater_management.service;

import com.codehub.theater_management.controller.dto.RoomDTO;
import com.codehub.theater_management.controller.dto.TicketDTO;
import com.codehub.theater_management.controller.mapper.RoomMapper;
import com.codehub.theater_management.model.Room;
import com.codehub.theater_management.model.Theater;
import com.codehub.theater_management.repository.RoomRepository;
import com.codehub.theater_management.repository.TheaterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private RoomMapper roomMapper;

    public RoomDTO salvar(RoomDTO roomDTO) {
        // Mapeia DTO para entidade, ignorando o theater no mapper
        Room room = roomMapper.toEntity(roomDTO);

        // Busca o theater no banco de dados
        Theater theater = theaterRepository.findById(roomDTO.getIdTheater())
                .orElseThrow(() -> new EntityNotFoundException("Theater with ID " + roomDTO.getIdTheater() + " not found"));

        // Associa o theater à room
        room.setTheater(theater);

        // Salva a entidade no banco
        Room savedRoom = repository.save(room);

        // Retorna o DTO mapeado a partir da entidade salva
        return roomMapper.toDTO(savedRoom);

    }

    public List<RoomDTO> listar(Pageable pageable){
        return repository.findAll(pageable)
                .map(roomMapper::toDTO)
                .getContent();
    }

}
