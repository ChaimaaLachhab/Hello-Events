package com.hello.controller;


import com.hello.Entity.Ticket;
import com.hello.Entity.User;
import com.hello.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Endpoint pour acheter un billet pour un événement (client)
    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestParam Long eventId, @RequestParam User user) {
        return reservationService.purchaseTicket(eventId, user);
    }

    // Endpoint pour récupérer tous les billets achetés par un utilisateur (client)
    @GetMapping("/user")
    public List<Ticket> getUserTickets(@RequestParam User user) {
        return reservationService.getTicketsByUser(user);
    }

    // Endpoint pour récupérer toutes les activités d'achat des clients (admin)
    @GetMapping("/purchases")
    public List<Ticket> getAllPurchases(@RequestParam User user) {
        return reservationService.getAllPurchases(user);
    }
}

