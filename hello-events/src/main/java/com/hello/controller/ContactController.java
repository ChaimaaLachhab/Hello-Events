package com.hello.controller;

import com.hello.Entity.Contact;
import com.hello.Entity.User;
import com.hello.enums.ContactStatus;
import com.hello.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Endpoint pour créer une nouvelle demande de contact (client)
    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    // Endpoint pour récupérer toutes les demandes de contact (admin)
    @GetMapping
    public List<Contact> getAllContacts(@RequestParam User user) {
        return contactService.getAllContacts(user);
    }

    // Endpoint pour récupérer une demande de contact par ID (admin)
    @GetMapping("/{id}")
    public Optional<Contact> getContactById(@PathVariable Long id, @RequestParam User user) {
        return contactService.getContactById(id, user);
    }

    // Endpoint pour mettre à jour le statut d'une demande de contact (admin)
    @PutMapping("/{id}")
    public Contact updateContactStatus(
            @PathVariable Long id,
            @RequestParam ContactStatus status,
            @RequestParam User user) {
        return contactService.updateContactStatus(id, status, user);
    }
}

