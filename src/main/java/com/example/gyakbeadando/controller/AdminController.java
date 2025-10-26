package com.example.gyakbeadando.controller;

import com.example.gyakbeadando.model.Authority;
import com.example.gyakbeadando.model.User;
import com.example.gyakbeadando.repo.AuthorityRepository;
import com.example.gyakbeadando.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    AuthorityRepository authorityRepo;

    @GetMapping("/admin")
    public String showAdminPage(@RequestHeader(value = "HX-Request", required = false) String hx, Model model) {

        model.addAttribute("users", userRepo.findAll());

        if (hx != null) {
            return "fragments/admin :: content";
        } else {
            model.addAttribute("view", "fragments/admin");
            return "layout";
        }
    }

    @GetMapping("/admin/users/edit/{username}")
    public String showEditPage(@PathVariable String username, @RequestHeader(value = "HX-Request", required = false) String hx, Model model) {

        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);

        if (hx != null) {
            return "fragments/edit_user :: content";
        } else {
            model.addAttribute("view", "fragments/edit_user");
            return "layout";
        }
    }

    @PostMapping("/admin/user/modosit")
    @Transactional
    public String modifyUser(
            @RequestParam String username,
            @RequestParam(defaultValue = "false") boolean enabled,
            @RequestParam String authority) {

        User user = userRepo.findByUsername(username);
        user.setAuthorities(null);
        user.setEnabled(enabled);
        userRepo.save(user);

        authorityRepo.deleteByUsername(username);
        Authority newAuth = new Authority();
        newAuth.setUsername(username);
        newAuth.setAuthority(authority);
        authorityRepo.save(newAuth);

        return "redirect:/admin";
    }
}
