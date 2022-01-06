package com.example.webshop.model;

import com.example.webshop.entity.AccountEntity;
import com.example.webshop.entity.RolesEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles extends Model{
    private String role;
    private AccountEntity account_id;

    public Roles(RolesEntity entity) {
        this.setId(entity.getId());
        this.role = entity.getRole();
    }
}
