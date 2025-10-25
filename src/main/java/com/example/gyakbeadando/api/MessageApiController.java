package com.example.gyakbeadando.api;

import com.example.gyakbeadando.model.Contact;
import com.example.gyakbeadando.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageApiController {
    @Autowired
    private ContactRepository repo;

    @GetMapping("/api/messages")
    Iterable<Contact> fetchAll() {
        return repo.findAll();
    }

    @GetMapping("/api/messages/{id}")
    Contact getMessage(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new MessageNotFoundException(id));
    }

    @PostMapping("/api/messages")
    Contact createMessage(@RequestBody Contact message) {
        return repo.save(message);
    }

    @PutMapping("/api/messages/{id}")
    Contact editMessage(@RequestBody Contact message, @PathVariable Integer id) {
        return repo.findById(id)
                .map(m -> {
                    m.setFullname(message.getFullname());
                    m.setEmail(message.getEmail());
                    m.setPhonenumber(message.getPhonenumber());
                    m.setMessage(message.getMessage());
                    return repo.save(m);
                })
                .orElseGet(() -> {
                    message.setId(id);
                    return repo.save(message);
                });
    }

    @DeleteMapping("/api/messages/{id}")
    void deleteMessage(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
