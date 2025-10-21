package com.example.gyakbeadando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class MessageController {

    @GetMapping("/messages")
    public String showMessages(@RequestHeader(value = "HX-Request", required = false) String hx) {
        return (hx != null) ? "fragments/messages :: content" : "layout";
    }
}
