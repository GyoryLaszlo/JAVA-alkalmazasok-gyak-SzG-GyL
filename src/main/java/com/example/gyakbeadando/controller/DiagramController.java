package com.example.gyakbeadando.controller;

import com.example.gyakbeadando.service.DiagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DiagramController {

    @Autowired
    private DiagramService diagramService;

    @GetMapping("/diagram")
    public String showPage(@RequestHeader(value = "HX-Request", required = false) String hx, Model model){
        model.addAttribute("avgPrices", diagramService.getAvgPricesByManufacturer());
        model.addAttribute("osCounts", diagramService.getNotebookCountByOS());
        model.addAttribute("displayCounts", diagramService.getNotebookCountByDisplaySize());

        if (hx != null) {
            return "fragments/diagram :: content";
        } else {
            model.addAttribute("view", "fragments/diagram");
            return "layout";
        }
    }
}
