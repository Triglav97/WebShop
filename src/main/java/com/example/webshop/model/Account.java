package com.example.webshop.model;

import com.example.webshop.entity.AccountEntity;
import com.example.webshop.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private String telephone_num;
    private String address;
    private List<Item> cart_items;

    public Account(AccountEntity entity) {
        this.id = entity.getId();
        this.telephone_num = entity.getTelephone_num();
        this.address = entity.getAddress();
        this.cart_items = entity.getCart_items()
                                .stream()
                                .map(Item::new)
                                .collect(Collectors.toList());
    }
}
