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
    private SpectacleRepository spectacleRepositoryrepository;

    @Autowired
    private ArmchairRepository armchairRepositoryrepository;

    @Autowired
    private ClientRepository clientRepositoryrepository;

    @Autowired
    private TicketPriceRepository TicketPriceRepository;

    @Autowired
    private TicketMapper mapper;

    public List<TicketDTO> getTicketsByClientId(Long clientId) {
        List<Ticket> tickets = repository.findTicketsByClientId(clientId);
        return tickets.stream()
                .map(mapper::toDTO)
                .toList();
    }


    public List<TicketDTO> listar(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDTO)
                .getContent();
    }


    public Ticket buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public TicketDTO salvar(TicketDTO ticketDTO) {
        Ticket ticket = mapper.toEntity(ticketDTO);

        System.out.println(ticketDTO.getSpectacleId());
        System.out.println(ticketDTO.getClientId());
        System.out.println(ticketDTO.getArmchairId());
        System.out.println(ticketDTO.getTicketPriceId());


        Spectacle spectacle = spectacleRepositoryrepository.findById(ticketDTO.getSpectacleId())
                .orElseThrow(()-> new RuntimeException("Spectacle Nao encontrado" + ticketDTO.getSpectacleId()));

        Client client = clientRepositoryrepository.findById(ticketDTO.getClientId())
                .orElseThrow(()-> new RuntimeException("Client Nao encontrado" + ticketDTO.getClientId()));

        Armchair armchair = armchairRepositoryrepository.findById(ticketDTO.getArmchairId())
                .orElseThrow(()-> new RuntimeException("Armchair Nao encontrado" + ticketDTO.getArmchairId()));

        TicketPrice ticketPrice = TicketPriceRepository.findById(ticketDTO.getTicketPriceId())
                .orElseThrow(()-> new RuntimeException("TicketPrice Nao encontrado" + ticketDTO.getTicketPriceId()));

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
