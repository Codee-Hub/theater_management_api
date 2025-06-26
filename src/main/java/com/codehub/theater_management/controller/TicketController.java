package com.codehub.theater_management.controller;

import com.codehub.theater_management.controller.dto.TicketDTO;
import com.codehub.theater_management.controller.dto.TicketPesquisaDTO;
import com.codehub.theater_management.controller.mapper.TicketMapper;
import com.codehub.theater_management.model.Ticket;
import com.codehub.theater_management.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tickets")
@Tag(name = "Ticket", description = "Endpoints para gerenciamento de Ticktes dos espetaculos")
public class TicketController {

    @Autowired
    private TicketService service;

    @Autowired
    private TicketMapper mapper;


    @GetMapping
    @Operation(summary = "Listar", description = "Lista todos os tickets")
    public ResponseEntity<List<TicketDTO>> listarTodos(
            @PageableDefault(size = 100, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        List<TicketDTO> tickets = service.listar(pageable);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Buscar", description = " consultar todos os ingressos comprados por um cliente específico\n")
    public ResponseEntity<List<TicketDTO>> getTicketsByClient(@PathVariable Long clientId) {
        List<TicketDTO> tickets = service.getTicketsByClientId(clientId);
        return ResponseEntity.ok(tickets);
    }


    @PostMapping
    @Operation(summary = "Criar", description = "Cria um ticket")
    public ResponseEntity<TicketDTO> salvar(@RequestBody TicketDTO dto) {
        try {
            TicketDTO salvo = service.salvar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar", description = "Atualiza um ticket")
    public TicketDTO atualizar(@PathVariable Long id, @RequestBody TicketDTO dto) {
        Ticket ticket = mapper.toEntity(dto);
        return mapper.toDTO(service.atualizar(id, ticket));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar", description = "Deleta um ticket")
    public String deletar(@PathVariable Long id) {
        return service.deletar(id) ? "Deletado com sucesso." : "Ticket não encontrado.";
    }


}
