package com.example.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class ItemEntity {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "itemIdSeq", sequenceName = "item_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemIdSeq")
    private Long Id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "cart_items")
    List<AccountEntity> accounts;

    @Override
    public String toString() {
        return "ItemEntity{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
