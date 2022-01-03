package com.example.webshop.controller;

import com.example.webshop.entity.AccountEntity;
import com.example.webshop.entity.ItemEntity;
import com.example.webshop.repository.AccountRepo;
import com.example.webshop.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private ItemRepo itemRepo;

    @GetMapping("/allusers")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/createuser")
    public ResponseEntity Saveuser(@RequestBody AccountEntity account) {
        try {
            accountRepo.save(account);
            return ResponseEntity.ok(accountRepo.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/createitem")
    public ResponseEntity Saveitem(@RequestBody ItemEntity item) {
        try {
            itemRepo.save(item);
            ItemEntity itemWithId = itemRepo.getById(3L);

            AccountEntity account = accountRepo.getById(2L);
            account.getCart_items().add(itemWithId);
            account.setCart_items(account.getCart_items());

            System.out.println(item.toString());
            System.out.println(account.toString());

            accountRepo.save(account);

            return ResponseEntity.ok(accountRepo.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/check")
    public ResponseEntity Check(){
        return ResponseEntity.ok(accountRepo.findAll());
    }

}
