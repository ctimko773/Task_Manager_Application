package com.Colin.Task_Manager.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Colin.Task_Manager.model.Contact;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {
    List<Contact> findByFirstName(String firstName);
    
}