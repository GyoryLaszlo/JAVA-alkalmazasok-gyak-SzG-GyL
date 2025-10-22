package com.example.gyakbeadando.controller;

import com.example.gyakbeadando.model.Gep;
import com.example.gyakbeadando.repo.GepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotebookController {
    @Autowired
    private GepRepository gepRepo;

    @GetMapping("/crud")
    public String showNotebooksPage(
            @RequestHeader(value = "HX-Request", required = false) String hx,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size,
            Model model) {

        Page<Gep> notebookPage = gepRepo.findAll(PageRequest.of(page, size));

        model.addAttribute("notebooks", notebookPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", notebookPage.getTotalPages());

        if (hx != null) {
            return "fragments/crud :: content";
        } else {
            model.addAttribute("view", "fragments/crud");
            return "layout";
        }
    }
}
