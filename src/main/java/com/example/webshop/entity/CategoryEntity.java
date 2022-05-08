package com.example.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "categoryIdSeq", sequenceName = "category_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryIdSeq")
    private Long Id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category_id")
    @Column(name = "items")
    @JsonIgnoreProperties("category_id")
    private List<ItemEntity> items;
}
