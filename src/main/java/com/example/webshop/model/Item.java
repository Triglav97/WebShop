package com.example.webshop.model;

import com.example.webshop.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long Id;
    private String name;

    public Item(ItemEntity entity) {
        this.Id = entity.getId();
        this.name = entity.getName();
    }
}
