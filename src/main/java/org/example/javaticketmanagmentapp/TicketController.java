package org.example.javaticketmanagmentapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TicketController {
    //inainte il primea ca obieect
    //private TicketService ticketService = new TicketService();

    //acum il primeste de la Spring
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // 1
    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // 2
    @PostMapping("/tickets")
    public void createTicket(@RequestBody Ticket ticket) {
        ticketService.createTicket(ticket);
    }

    //3
    @GetMapping("/tickets/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    //4
    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }


    //5
    @PutMapping("/tickets/{id}")
    public void updateTicket(@PathVariable Long id, @RequestBody Ticket updatedTicket) {
        ticketService.updateTicket(id, updatedTicket);
    }
}