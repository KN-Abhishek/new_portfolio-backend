package com.portfolio_react.portfolio_react.service;

import com.portfolio_react.portfolio_react.model.Contact;
import com.portfolio_react.portfolio_react.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;


    public Contact saveMessage(Contact message) {
        return repository.save(message);
    }


    public List<Contact> getAllMessages() {
        return repository.findAll();
    }


    public Optional<Contact> getMessageById(Long id) {
        return repository.findById(id);
    }


    public void deleteMessageById(Long id) {
        repository.deleteById(id);
    }
}
