package com.example.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "categoryIdSeq", sequenceName = "category_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryIdSeq")
    private Long Id;
}
