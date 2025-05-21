package com.codehub.theater_management.service;

import com.codehub.theater_management.controller.dto.TicketPriceDTO;
import com.codehub.theater_management.controller.mapper.TicketPriceMapper;
import com.codehub.theater_management.model.PersonType;
import com.codehub.theater_management.model.Spectacle;
import com.codehub.theater_management.model.TicketPrice;
import com.codehub.theater_management.repository.TicketPriceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketPriceService {

    @Autowired
    public TicketPriceRepository repository;

    @Autowired
    public TicketPriceMapper mapper;

    public TicketPriceDTO salvar(TicketPriceDTO ticketPriceDTO) {
        TicketPrice ticketPrice = mapper.toEntity(ticketPriceDTO);

        Spectacle spectacle = repository.findById(ticketPriceDTO.getIdSpectacle())
                .orElseThrow(()-> new RuntimeException("Spectale Nao encontrado" + ticketPriceDTO.getIdSpectacle())).getSpectacle();

        PersonType personType = repository.findById(ticketPriceDTO.getIdPersonType())
                .orElseThrow(()-> new RuntimeException("PersonType Nao encontrado" + ticketPriceDTO.getIdPersonType())).getPersonType();

        ticketPrice.setSpectacle(spectacle);
        ticketPrice.setPersonType(personType);

        TicketPrice saved = repository.save(ticketPrice);


        return mapper.toDTO(saved);

    }

    public List<TicketPriceDTO> Listar() {
        return  repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }


    public TicketPrice deletar(TicketPrice ticketPrice) {
        repository.delete(ticketPrice);
        return ticketPrice;
    }


}
