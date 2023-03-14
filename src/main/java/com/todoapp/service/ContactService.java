package com.todoapp.service;

import com.todoapp.model.Contact;
import com.todoapp.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;

    public Contact addContact(Contact contact) {
        return contactRepo.save(contact);
    }

    public Optional<Contact> getContactById(int id) {
        return contactRepo.findById(id);
    }
}
