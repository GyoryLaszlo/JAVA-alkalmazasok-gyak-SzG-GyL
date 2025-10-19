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
        @GetMapping("/database")
        public String database(@RequestHeader(value="HX-Request", required=false) String hx) {
            return (hx!=null)?"fragments/database :: content":"layout";
        }
        @GetMapping("/contact") public String contact(@RequestHeader(value="HX-Request", required=false) String hx) {
            return (hx!=null)?"fragments/contact :: content":"layout";
        }
        @GetMapping("/messages") public String messages(@RequestHeader(value="HX-Request", required=false) String hx) {
            return (hx!=null)?"fragments/messages :: content":"layout";
        }
        @GetMapping("/chart") public String chart(@RequestHeader(value="HX-Request", required=false) String hx) {
            return (hx!=null)?"fragments/chart :: content":"layout";
        }
        @GetMapping("/crud") public String crud(@RequestHeader(value="HX-Request", required=false) String hx) {
            return (hx!=null)?"fragments/crud :: content":"layout";
        }
        @GetMapping("/restful") public String restful(@RequestHeader(value="HX-Request", required=false) String hx) {
            return (hx!=null)?"fragments/restful :: content":"layout";
        }
        @GetMapping("/admin") public String admin(@RequestHeader(value="HX-Request", required=false) String hx) {
            return (hx!=null)?"fragments/admin :: content":"layout";
        }

        @GetMapping("/login") public String login(@RequestHeader(value="HX-Request", required=false) String hx) {
            return (hx!=null)?"fragments/login :: content":"layout";
        }

        private final GepRepository gepRepository;


        public PageController(GepRepository gepRepository) {
            this.gepRepository = gepRepository;
        }



    }

