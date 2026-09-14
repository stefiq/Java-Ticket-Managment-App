package org.example.javaticketmanagmentapp;

import org.springframework.data.jpa.repository.JpaRepository;
                                                      //cu ce obiecte lucrezi, tipul cheii primare
public interface TicketRepository extends JpaRepository<Ticket, Long> {


}
