package com.example.webshop.model;

import com.example.webshop.entity.AccountEntity;
import com.example.webshop.entity.ItemEntity;
import com.example.webshop.entity.PasswordEntity;
import com.example.webshop.entity.RolesEntity;
import com.example.webshop.service.SomeFunctions.ConvertWithComma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.webshop.service.SomeFunctions.ConvertWithComma.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account extends Model {
    private Long Id;
    private String name;
    private String telephone_num;
    private String address;
    private List<RolesEntity> roles;
    private PasswordEntity password;
    private List<ItemEntity> items;

    public Account(Optional<AccountEntity> entity) {
        this.setId(entity.get().getId());
        this.setName(entity.get().getName());
        this.setTelephone_num(entity.get().getTelephone_num());
        this.setAddress(entity.get().getAddress());
        this.setRoles(entity.get().getRoles());
        //this.setPassword(entity.get().getPassword());
        this.setItems(entity.get().getItems());
        this.address = entity.get().getAddress();
    }
}
