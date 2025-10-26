package com.example.demo.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.demo.repository.entity.Ticket;
import com.example.demo.repository.entity.User;

public interface TicketRepository extends ListCrudRepository <Ticket, Integer> {

    Ticket findById(int id);

    Ticket findByCreator(User creator);

    Ticket findByDestinatary(User destinatary);
    
    Ticket findByTechnician(User technician);

}
