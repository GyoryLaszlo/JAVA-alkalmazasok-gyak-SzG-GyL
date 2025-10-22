package com.example.gyakbeadando.controller;

import com.example.gyakbeadando.model.Contact;
import com.example.gyakbeadando.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private ContactRepository messageRepo;

    @GetMapping("/messages")
    public String showMessages(@RequestHeader(value = "HX-Request", required = false) String hx, Model model) {
        List<Contact> messages = messageRepo.findAllMessagesOrderByTimeDesc();
        model.addAttribute("messages", messages);
        return (hx != null) ? "fragments/messages :: content" : "layout";
    }
}
