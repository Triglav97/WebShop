// package com.example.webshop.controller;

// import com.example.webshop.entity.AccountEntity;
// import com.example.webshop.entity.ItemEntity;
// import com.example.webshop.entity.PasswordEntity;
// import com.example.webshop.entity.RolesEntity;
// import com.example.webshop.model.Account;
// import com.example.webshop.model.Item;
// import com.example.webshop.model.Password_never_use;
// import com.example.webshop.model.Roles;
// import com.example.webshop.repository.AccountRepo;
// import com.example.webshop.repository.ItemRepo;
// import com.example.webshop.repository.PasswordRepo;
// import com.example.webshop.repository.RolesRepo;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;

// import java.util.ArrayList;
// import java.util.List;

// @Controller
// @RequestMapping("/test")
// public class TestController {

//     @Autowired
//     private AccountRepo accountRepo;

//     @Autowired
//     private ItemRepo itemRepo;

//     @Autowired
//     private PasswordRepo passwordRepo;

//     @Autowired
//     private RolesRepo rolesRepo;

//     @GetMapping("/allusers")
//     public ResponseEntity<?> getAllUsers() {
//         return new ResponseEntity<>(HttpStatus.CREATED);
//     }

//     @PostMapping("/createuser")
//     public ResponseEntity Saveuser(@RequestBody AccountEntity account) {
//         try {
//             accountRepo.save(account);
//             return ResponseEntity.ok(accountRepo.findAll());
//         } catch (Exception e) {
//             return ResponseEntity.badRequest().body("Произошла ошибка");
//         }
//     }

//     //не использовать пока
//     @PostMapping("/createitemError")
//     public ResponseEntity Saveitem(@RequestBody ItemEntity item) {
//         try {
//             itemRepo.save(item);
//             ItemEntity itemWithId = itemRepo.getById(14L);

//             AccountEntity account = accountRepo.getById(10L);
// //            account.getCart_items().add(itemWithId);
// //            account.setCart_items(account.getCart_items());

// //            System.out.println(item.toString());
// //            System.out.println(account.toString());

//             accountRepo.save(account);

//             return ResponseEntity.ok(accountRepo.findAll());
//         }catch (Exception e){
//             return ResponseEntity.badRequest().body("Произошла ошибка");
//         }
//     }

//     @GetMapping("/check")
//     public ResponseEntity Check(){
//         return ResponseEntity.ok(accountRepo.findAll());
//     }

//     @GetMapping("/checkAll") // вывод всех сущностей
//     public String CheckAll(Model model){
//         List<Account> account = new ArrayList<>();
//         List<AccountEntity> accountEntities = accountRepo.findAll();
//         for(var entity: accountEntities){
//             account.add(new Account(entity));
//         }
//         model.addAttribute("Accounts", account);

//         List<Item> items = new ArrayList<>();
//         List<ItemEntity> itemEntities = itemRepo.findAll();
//         for(var entity: itemEntities){
//             items.add(new Item(entity));
//         }
//         model.addAttribute("Items", items);

//         List<Password_never_use> passwords_never_use = new ArrayList<>();
//         List<PasswordEntity> passwordEntities = passwordRepo.findAll();
//         for(var entity: passwordEntities){
//             passwords_never_use.add(new Password_never_use(entity));
//         }
//         model.addAttribute("Passwords", passwords_never_use);

//         List<Roles> roles = new ArrayList<>();
//         List<RolesEntity> rolesEntities = rolesRepo.findAll();
//         for(var entity: rolesEntities){
//             roles.add(new Roles(entity));
//         }
//         model.addAttribute("Roles", roles);

//         return "CheckOutAll";
//     }



// }
