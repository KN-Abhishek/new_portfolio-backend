package com.portfolio_react.portfolio_react.controller;

import com.portfolio_react.portfolio_react.model.Contact;
import com.portfolio_react.portfolio_react.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactController {

    @Autowired
    private ContactService service;


    @PostMapping
    public ResponseEntity<?> saveMessage(@RequestBody Contact message) {
        try {
            Contact savedMessage = service.saveMessage(message);
            return ResponseEntity.ok(savedMessage);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving message: " + e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<List<Contact>> getAllMessages() {
        try {
            List<Contact> messages = service.getAllMessages();
            return ResponseEntity.ok(messages);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable Long id) {
        try {
            Optional<Contact> message = service.getMessageById(id);
            if (message.isPresent()) {
                return ResponseEntity.ok(message.get());
            } else {
                return ResponseEntity.status(404).body("Message not found with ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving message: " + e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessageById(@PathVariable Long id) {
        try {
            Optional<Contact> message = service.getMessageById(id);
            if (message.isPresent()) {
                service.deleteMessageById(id);
                return ResponseEntity.ok("Message with ID " + id + " deleted successfully.");
            } else {
                return ResponseEntity.status(404).body("Message not found with ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting message: " + e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateMessage(@PathVariable Long id, @RequestBody Contact updatedContact) {
        try {
            Optional<Contact> existingContact = service.getMessageById(id);
            if (existingContact.isPresent()) {
                Contact contact = existingContact.get();
                contact.setName(updatedContact.getName());
                contact.setEmail(updatedContact.getEmail());
                contact.setMessage(updatedContact.getMessage());

                // Save the updated contact
                Contact updated = service.saveMessage(contact);
                return ResponseEntity.ok(updated);
            } else {
                return ResponseEntity.status(404).body("Message not found with ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating message: " + e.getMessage());
        }
    }
}
