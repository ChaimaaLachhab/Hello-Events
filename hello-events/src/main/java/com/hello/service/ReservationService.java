package com.hello.service;

import com.hello.Entity.Event;
import com.hello.Entity.Ticket;
import com.hello.Entity.User;
import com.hello.enums.Role;
import com.hello.repository.EventRepository;
import com.hello.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;

    @Autowired
    public ReservationService(TicketRepository ticketRepository, EventRepository eventRepository) {
        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
    }

    // Acheter un billet pour un événement
    public Ticket purchaseTicket(Long eventId, User user) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        if (event.getAvailableTickets() > 0) {
            Ticket ticket = new Ticket(event, user);

            event.setAvailableTickets(event.getAvailableTickets() - 1);

            eventRepository.save(event);
            return ticketRepository.save(ticket);
        } else {
            throw new IllegalStateException("No available tickets for this event");
        }
    }


    // Récupérer tous les billets achetés par un utilisateur
    public List<Ticket> getTicketsByUser(User user) {
        return ticketRepository.findByUser(user);
    }

    // Récupérer toutes les activités d'achat des clients (admin)
    public List<Ticket> getAllPurchases(User user) {
        if (user.getRole() == Role.ROLE_ADMIN) {
            return ticketRepository.findAll();
        }
        throw new SecurityException("Access Denied");
    }
}
