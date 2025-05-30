package com.codehub.theater_management.service;

import com.codehub.theater_management.controller.dto.TicketDTO;
import com.codehub.theater_management.controller.mapper.TicketMapper;
import com.codehub.theater_management.model.*;
import com.codehub.theater_management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {


    @Autowired
    private TicketRepository repository;

    @Autowired
    private TicketMapper mapper;

    public List<TicketDTO> listar(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDTO)
                .getContent();
    }

//    public List<TicketDTO> listar() {
//        return repository.findAll()
//                .stream()
//                .map(mapper::toDTO)
//                .collect(Collectors.toList());
//    }

    public Ticket buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public TicketDTO salvar(TicketDTO ticketDTO) {
        Ticket ticket = mapper.toEntity(ticketDTO);

        Spectacle spectacle = repository.findById(ticketDTO.getSpectacleId())
                .orElseThrow(()-> new RuntimeException("Spectacle Nao encontrado" + ticketDTO.getSpectacleId())).getSpectacle();

        Client client = repository.findById(ticketDTO.getClientId())
                .orElseThrow(()-> new RuntimeException("Client Nao encontrado" + ticketDTO.getClientId())).getClient();

        Armchair armchair = repository.findById(ticketDTO.getArmchairId())
                .orElseThrow(()-> new RuntimeException("Armchair Nao encontrado" + ticketDTO.getArmchairId())).getArmchair();

        TicketPrice ticketPrice = repository.findById(ticketDTO.getTicketPriceId())
                .orElseThrow(()-> new RuntimeException("TicketPrice Nao encontrado" + ticketDTO.getTicketPriceId())).getTicketPrice();

        ticket.setSpectacle(spectacle);
        ticket.setClient(client);
        ticket.setArmchair(armchair);
        ticket.setTicketPrice(ticketPrice);

        Ticket ticketSalvo = repository.save(ticket);
        return mapper.toDTO(ticketSalvo);
    }

    public Ticket atualizar(Long id, Ticket novoTicket) {
        if (!repository.existsById(id)) return null;

        novoTicket.setId(id);
        return repository.save(novoTicket);
    }

    public boolean deletar(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }



}
