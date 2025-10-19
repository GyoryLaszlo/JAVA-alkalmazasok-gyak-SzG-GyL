package com.example.gyakbeadando.controller;

import com.example.gyakbeadando.repo.GepRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class PageController {

        @GetMapping("/")
        public String home(@RequestHeader(value="HX-Request", required=false) String hx) {
            return (hx != null) ? "fragments/home :: content" : "layout";
        }

    }

