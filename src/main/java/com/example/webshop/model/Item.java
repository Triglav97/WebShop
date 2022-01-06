package com.example.webshop.model;

import com.example.webshop.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item extends Model{
    private String name;

    public Item(ItemEntity entity) {
        this.setId(entity.getId());
        this.name = entity.getName();
    }
}
