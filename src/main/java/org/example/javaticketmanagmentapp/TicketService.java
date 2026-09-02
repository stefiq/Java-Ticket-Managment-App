package org.example.javaticketmanagmentapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private List<Ticket> tickets = new ArrayList<>();

    public void createTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public Ticket getTicketById(Long id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId().equals(id)) {
                return ticket;
            }
        }

        return null;
    }

    public void deleteTicket(Long id) {
        tickets.removeIf(ticket -> ticket.getId().equals(id));
    }

    public void updateTicket(Long id, Ticket updatedTicket) {
        Ticket ticket = getTicketById(id);

        if (ticket != null) {
            ticket.setTitle(updatedTicket.getTitle());
            ticket.setDescription(updatedTicket.getDescription());
            ticket.setStatus(updatedTicket.getStatus());
        }
    }
}