package com.example.gyakbeadando.controller;

import com.example.gyakbeadando.model.Gep;
import com.example.gyakbeadando.repo.GepRepository;
import com.example.gyakbeadando.repo.OprendszerRepository;
import com.example.gyakbeadando.repo.ProcesszorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NotebookController {
    @Autowired
    private GepRepository gepRepo;
    @Autowired
    private ProcesszorRepository processorRepo;
    @Autowired
    private OprendszerRepository osRepo;

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
            return "fragments/crud/index :: content";
        } else {
            model.addAttribute("view", "fragments/crud/index");
            return "layout";
        }
    }

    @GetMapping("/crud/uj")
    public String showCreateNewNotebookPage(@RequestHeader(value = "HX-Request", required = false) String hx, Model model) {
        model.addAttribute("notebook", new Gep());
        model.addAttribute("processors", processorRepo.findAll());
        model.addAttribute("opSystems", osRepo.findAll());

        if (hx != null) {
            return "fragments/crud/create :: content";
        } else {
            model.addAttribute("view", "fragments/crud/create");
            return "layout";
        }
    }

    @PostMapping(value = "/crud/ment")
    public String save(@ModelAttribute Gep notebook) {
        gepRepo.save(notebook);
        return "redirect:/crud";
    }

    @GetMapping("/crud/edit/{id}")
    public String showEditPage(@PathVariable(name = "id") long id, @RequestHeader(value = "HX-Request", required = false) String hx, Model model) {
        model.addAttribute("notebook", gepRepo.findById(id));
        model.addAttribute("processors", processorRepo.findAll());
        model.addAttribute("opSystems", osRepo.findAll());

        if (hx != null) {
            return "fragments/crud/edit :: content";
        } else {
            model.addAttribute("view", "fragments/crud/edit");
            return "layout";
        }
    }

    @PostMapping(value = "/crud/modosit")
    public String modifyNotebook(@ModelAttribute Gep notebook) {
        gepRepo.save(notebook);
        return "redirect:/crud";
    }

    @GetMapping("/crud/delete/{id}")
    public String deleteNotebook(@PathVariable(name = "id") long id) {
        gepRepo.delete(gepRepo.findById(id).get());
        return "redirect:/crud";
    }
}
