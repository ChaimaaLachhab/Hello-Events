package com.hello.service;

import com.hello.Entity.Contact;
import com.hello.Entity.User;
import com.hello.enums.ContactStatus;
import com.hello.enums.Role;
import com.hello.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Créer une nouvelle demande de contact
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    // Récupérer toutes les demandes de contact (administrateur)
    public List<Contact> getAllContacts(User user) {
        if (user.getRole() == Role.ADMIN) {
            return contactRepository.findAll();
        }
        throw new SecurityException("Access Denied");
    }

    // Récupérer une demande de contact par son ID
    public Optional<Contact> getContactById(Long id, User user) {
        if (user.getRole() == Role.ADMIN) {
            return contactRepository.findById(id);
        }
        throw new SecurityException("Access Denied");
    }

    // Mettre à jour l'état d'une demande de contact
    public Contact updateContactStatus(Long id, ContactStatus status, User user) {
        if (user.getRole() == Role.ADMIN) {
            Contact contact = contactRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Contact not found"));

            contact.setStatus(status);
            return contactRepository.save(contact);
        }
        throw new SecurityException("Access Denied");
    }
}
