package com.example.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainPageController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World")
            String name, Model model
            ) {
        model.addAttribute("name", name);
        return "test";
    }

    @GetMapping
    public String mainPage(Map<String, Object> model) {
        return "MainPage";
    }
}
