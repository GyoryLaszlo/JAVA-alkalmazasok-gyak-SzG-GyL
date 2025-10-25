package com.example.gyakbeadando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class RESTfulController {

    @GetMapping("/restful")
    public String showRESTfulPage(@RequestHeader(value = "HX-Request", required = false) String hx, Model model){
        if (hx != null) {
            return "fragments/restful :: content";
        } else {
            model.addAttribute("view", "fragments/restful");
            return "layout";
        }
    }
}
