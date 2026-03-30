package com.Colin.Task_Manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Colin.Task_Manager.repository.ContactRepository;
import com.Colin.Task_Manager.model.Contact;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository repo;

    public List<Contact> getAllContacts() {
        return repo.findAll();
    }

    public Contact createContact(Contact contact) {
        boolean exists = repo.findByFirstName(contact.getFirstName()).stream()
            .anyMatch(existingContact -> existingContact.getLastName().equals(contact.getLastName()));
        if (!exists) {
            repo.save(contact);
        }
        return contact;
    }
}
    

