package com.example.webshop.model;

import com.example.webshop.entity.AccountEntity;
import com.example.webshop.entity.PasswordEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Password_never_use extends Model{
    private String pass;
    private AccountEntity account_id;

    public Password_never_use(PasswordEntity entity) {
        this.setId(entity.getId());
        this.pass = entity.getPass();
    }
}
