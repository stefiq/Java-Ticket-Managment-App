package org.example.javaticketmanagmentapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    //in loc de lista folosim ticketRepository
    //private List<Ticket> tickets = new ArrayList<>();
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void createTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
//        for (Ticket t : ticketRepository.findAll()){
//            if(t.getId().equals(id)){
//                ticketRepository.delete(t);
//            }
//        }
    }

    public void updateTicket(Long id, Ticket updatedTicket) {
        Ticket ticket = getTicketById(id);

        if (ticket != null) {
            ticket.setTitle(updatedTicket.getTitle());
            ticket.setDescription(updatedTicket.getDescription());
            ticket.setStatus(updatedTicket.getStatus());
            ticket.setPriority(updatedTicket.getPriority());
            ticket.setCategory(updatedTicket.getCategory());
            ticketRepository.save(ticket);
        }
    }

    public void changeTicketStatus(Long id, String newStatus){
        Ticket t = getTicketById(id);

        if(t != null){
            t.setStatus(newStatus);
            ticketRepository.save(t);
        }

    }

    public void closeTicket(Long id){
        Ticket t = getTicketById(id);

        if(t != null){
            t.setStatus("CLOSED");
            ticketRepository.save(t);
        }
    }

    public void openTicket(Long id){
        Ticket t = getTicketById(id);

        if(t != null){
            t.setStatus("OPEN");
            ticketRepository.save(t);
        }
    }

    public int countTicketsByStatus(String status){
        int count = 0;
        for (Ticket t : ticketRepository.findAll()){
            if (t.getStatus().equalsIgnoreCase(status)){
                count++;
            }
        }

        return count;
    }
}