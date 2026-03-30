package com.Colin.Task_Manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Colin.Task_Manager.model.Contact;
import com.Colin.Task_Manager.service.ContactService;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "*")

public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public java.util.List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        contactService.createContact(contact);

        return contact; // Placeholder return statement
    }

    
}
