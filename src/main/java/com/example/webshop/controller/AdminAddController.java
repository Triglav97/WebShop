package com.example.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/add")
public class AdminAddController {

    @GetMapping("/AdminAddIntoBd")
    public String AdminAddIntoBd(){
        return "AdminAddIntoBd";
    }
}
