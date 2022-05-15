package com.example.webshop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.example.webshop.entity.AccountEntity;
import com.example.webshop.entity.CategoryEntity;
import com.example.webshop.entity.CorpEntity;
import com.example.webshop.entity.ItemEntity;
import com.example.webshop.entity.PasswordEntity;
import com.example.webshop.entity.RolesEntity;
import com.example.webshop.repository.AccountRepo;
import com.example.webshop.repository.CategoryItemRepo;
import com.example.webshop.repository.CorpRepo;
import com.example.webshop.repository.ItemRepo;
import com.example.webshop.repository.PasswordRepo;
import com.example.webshop.repository.RolesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    private CorpRepo corpNameRepo;

    @Autowired
    private ItemRepo itemRepo;

    @GetMapping("/addIntoBd")
    public String addIntoBd(Model model){
        List<CategoryEntity> categoryEntities = categoryItemRepo.findAll();
        model.addAttribute("Categories", categoryEntities);

        List<CorpEntity> corpNameEntities = corpNameRepo.findAll();
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
        CorpEntity corpNameEntity = new CorpEntity();
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

            CorpEntity corpNameEntity = new CorpEntity();
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

    @DeleteMapping(value = "/deleteAccById")
    public ResponseEntity<?> deleteAccById(@RequestParam Long id){
        AccountEntity accountEntity = (accountRepo.findById(id).stream().toList()).get(0);
        
        //corpNameRepo.deleteById(id);
        
        return accountEntity != null
                ? new ResponseEntity<>(accountEntity, HttpStatus.OK)
                 : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
