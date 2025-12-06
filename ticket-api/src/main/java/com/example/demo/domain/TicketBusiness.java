package com.example.demo.domain;

import org.springframework.validation.annotation.Validated;

import com.example.demo.controller.dto.NewTicketDTO;
import com.example.demo.controller.dto.UpdateTicketDTO;
import com.example.demo.domain.stereotype.Business;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.entity.Ticket;

import jakarta.validation.Valid;

// Spring -> possui um container de Injeção de Dependências

// estereótipo
@Business // Domain, DomainService, Service, UseCase
@Validated
public class TicketBusiness {

    private final TicketRepository ticketRepository;
    public TicketBusiness(
        TicketRepository ticketRepository
    ) {
        this.ticketRepository = ticketRepository;
    }
    

    public void createTicket(@Valid NewTicketDTO newTicket) {
        Ticket ticket = new Ticket();
        
        ticket.setCreator(newTicket.creator());
        ticket.setDestinatary(newTicket.destinatary());
        ticket.setItem(newTicket.item());
        ticket.setTo_do(newTicket.to_do());
        ticket.setDetails(newTicket.details());
        ticket.setPlace(newTicket.place());

        ticketRepository.save(ticket); 
    }

    public void updateTicket(@Valid UpdateTicketDTO updateTicket, int id){

        Ticket ticket = ticketRepository.findById(id);

        ticket.setStatus(updateTicket.status());

        ticketRepository.save(ticket);
    }
}
