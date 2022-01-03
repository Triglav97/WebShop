package com.example.webshop.model;

import com.example.webshop.entity.AccountEntity;
import com.example.webshop.entity.RolesEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles {
    private Long Id;
    private String role;
    private AccountEntity account_id;

    public Roles(RolesEntity entity) {
        this.Id = entity.getId();
        this.role = entity.getRole();
        this.account_id = entity.getAccount_id();
    }
}
