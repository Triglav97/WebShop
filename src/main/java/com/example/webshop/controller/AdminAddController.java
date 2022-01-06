package com.example.webshop.controller;

import com.example.webshop.entity.AccountEntity;
import com.example.webshop.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/add")
public class AdminAddController {

    @Autowired
    private AccountRepo accountRepo;

    @GetMapping("/AdminAddIntoBd")
    public String AdminAddIntoBd(){
        return "AdminAddIntoBd";
    }

    @PostMapping("/addAccount")
    public String addAccount(@RequestParam Map<String, String> par){
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(par.get("name"));
        accountEntity.setTelephone_num(par.get("tel_num"));
        accountEntity.setAddress(par.get("address"));

        accountRepo.save(accountEntity);
//        System.out.println(model.getAttribute("name"));
        System.out.println();
//        AccountEntity accountEntity = new AccountEntity(model);

        return "AdminAddIntoBd";
    }
}
