package com.example.webshop.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


import com.example.webshop.entity.AccountEntity;
import com.example.webshop.entity.CategoryEntity;
import com.example.webshop.entity.CorpNameEntity;
import com.example.webshop.entity.ItemEntity;
import com.example.webshop.entity.PasswordEntity;
import com.example.webshop.entity.RolesEntity;
import com.example.webshop.repository.AccountRepo;
import com.example.webshop.repository.CategoryItemRepo;
import com.example.webshop.repository.CorpNameRepo;
import com.example.webshop.repository.ItemRepo;
import com.example.webshop.repository.PasswordRepo;
import com.example.webshop.repository.RolesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ContextPathCompositeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ch.qos.logback.core.Context;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Value("${upload.path.picture}")
    private String picturePath;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private PasswordRepo passwordRepo;

    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    private CategoryItemRepo categoryItemRepo;

    @Autowired
    private CorpNameRepo corpNameRepo;

    @Autowired
    private ItemRepo itemRepo;

    @GetMapping("/addIntoBd")
    public String addIntoBd(Model model){
        List<CategoryEntity> categoryEntities = categoryItemRepo.findAll();
        model.addAttribute("Categories", categoryEntities);

        List<CorpNameEntity> corpNameEntities = corpNameRepo.findAll();
        model.addAttribute("Corps", corpNameEntities);

        return "AdminAddIntoBd";
    }

    @PostMapping("/addAccount")
    public String addAccount(@RequestParam Map<String, String> par){
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(par.get("name"));
        accountEntity.setTelephone_num(par.get("tel_num"));
        accountEntity.setAddress(par.get("address"));

        accountRepo.save(accountEntity);

        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setAccount_id(accountEntity);
        passwordEntity.setPass(par.get("password"));

        passwordRepo.save(passwordEntity);

        return "redirect:" + "../admin/addIntoBd";
    }

    @PostMapping("/addRole")
    public String addRole(@RequestParam Map<String, String> par){
        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setRole(par.get("role"));

        rolesRepo.save(rolesEntity);

        return "redirect:" + "../admin/addIntoBd";
    }

    @PostMapping("/addCategory")
    public String addCategory(@RequestParam Map<String, String> par){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(par.get("сategory"));
        
        categoryItemRepo.save(categoryEntity);
        
        return "redirect:" + "../admin/addIntoBd";
    }

    @PostMapping("/addCorp")
    public String addCorp(@RequestParam Map<String, String> par){
        CorpNameEntity corpNameEntity = new CorpNameEntity();
        corpNameEntity.setName(par.get("corp"));

        corpNameRepo.save(corpNameEntity);

        return "redirect:" + "../admin/addIntoBd";
    }

    @PostMapping("/addItem")
    public String addItem(@RequestParam Map<String, String> par, @RequestParam("filePicture") MultipartFile file){
        
        String uuidFile = UUID.randomUUID().toString();
        String resultFilename = par.get("itemName") + "+" + uuidFile + ".jpg";

        try {
            file.transferTo(new File(picturePath + "/" + resultFilename));
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setName(par.get("itemName"));

            itemEntity.setPicture_name(resultFilename);

            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity = categoryItemRepo.findByName(par.get("categoryName")).get(0);
            itemEntity.setCategory_id(categoryEntity);

            CorpNameEntity corpNameEntity = new CorpNameEntity();
            corpNameEntity = corpNameRepo.findByName(par.get("corpName")).get(0);
            itemEntity.setCorp_id(corpNameEntity);
            
            itemRepo.save(itemEntity);

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        return "redirect:" + "../admin/addIntoBd";
    }

    @GetMapping(value = "/checkClientAll")
    public ResponseEntity<?> read() {
        List <AccountEntity> accountEntities = accountRepo.findAll(); 
        return accountEntities != null && !accountEntities.isEmpty()
               ? new ResponseEntity<>(accountEntities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
