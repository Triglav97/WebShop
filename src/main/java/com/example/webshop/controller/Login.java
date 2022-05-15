package com.example.webshop.controller;

import java.util.Map;

import com.example.webshop.entity.AccountEntity;
import com.example.webshop.entity.PasswordEntity;
import com.example.webshop.repository.AccountRepo;
import com.example.webshop.repository.PasswordRepo;
import com.example.webshop.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    AccountRepo accountRepo;

    @Autowired
    PasswordRepo passwordRepo;

    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    @GetMapping("/registration")
    public String registration(){
        return "Registration";
    }

    @PostMapping("/registration")
    public String addAccount(@RequestParam Map<String, String> par, Map<String, Object> model){
        if (accountRepo.findByName(par.get("name")).size() != 0){
            model.put("message", "Аккаунт с таким именем существует!");
            return "Registration";
        }

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(par.get("name"));
        accountEntity.setTelephone_num(par.get("tel_num"));
        accountEntity.setAddress(par.get("address"));

        accountRepo.save(accountEntity);
        
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setAccount_id(accountEntity);
        passwordEntity.setPass(bCryptPasswordEncoder.encode(par.get("password")));

        passwordRepo.save(passwordEntity);

        return "redirect:" + "/login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:" + "/";
    }
}
