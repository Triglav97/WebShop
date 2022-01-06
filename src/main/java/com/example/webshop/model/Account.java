package com.example.webshop.model;

import com.example.webshop.entity.AccountEntity;
import com.example.webshop.service.SomeFunctions.ConvertWithComma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.webshop.service.SomeFunctions.ConvertWithComma.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account extends Model {
    private String name;
    private String telephone_num;
    private String address;
    private String roles;
    private List<Item> cart_items;

    public Account(AccountEntity entity) {
        this.setId(entity.getId());
        this.name = entity.getName();
        this.telephone_num = entity.getTelephone_num();
        this.address = entity.getAddress();
        this.roles = ListToString(entity.getRoles()
                            .stream()
                            .map(Roles::new)
                            .collect(Collectors.toList()));
//        this.cart_items = entity.getCart_items()
//                                .stream()
//                                .map(Item::new)
//                                .collect(Collectors.toList());
    }
}
