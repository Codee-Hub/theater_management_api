package com.codehub.theater_management.service;

import com.codehub.theater_management.controller.dto.TicketPriceDTO;
import com.codehub.theater_management.controller.mapper.TicketPriceMapper;
import com.codehub.theater_management.model.PersonType;
import com.codehub.theater_management.model.Spectacle;
import com.codehub.theater_management.model.TicketPrice;
import com.codehub.theater_management.repository.PersonTypeRepository;
import com.codehub.theater_management.repository.SpectacleRepository;
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

    @Autowired
    public SpectacleRepository spectacleRepository;

    @Autowired
    public PersonTypeRepository personTypeRepository;

    public TicketPriceDTO salvar(TicketPriceDTO ticketPriceDTO) {
        TicketPrice ticketPrice = mapper.toEntity(ticketPriceDTO);

        System.out.println(ticketPriceDTO.getIdSpectacle());
        System.out.println(ticketPriceDTO.getIdPersonType());

        Spectacle spectacle = spectacleRepository.findById(ticketPriceDTO.getIdSpectacle())
                .orElseThrow(()-> new RuntimeException("Spectale Nao encontrado" + ticketPriceDTO.getIdSpectacle()));

        PersonType personType = personTypeRepository.findById(ticketPriceDTO.getIdPersonType())
                .orElseThrow(()-> new RuntimeException("PersonType Nao encontrado" + ticketPriceDTO.getIdPersonType()));

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

    public TicketPriceDTO buscarPorId(Long id) {
        return mapper.toDTO(repository.findById(id).get()) ;
    }


    public TicketPrice deletar(TicketPrice ticketPrice) {
        repository.delete(ticketPrice);
        return ticketPrice;
    }

}
