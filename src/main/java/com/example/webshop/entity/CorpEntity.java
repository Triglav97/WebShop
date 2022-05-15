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
@Table(name = "corp")
public class CorpEntity {
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "corpIdSeq", sequenceName = "corp_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "corpIdSeq")
    private Long Id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corp_id")
    @Column(name = "items")
    @JsonIgnoreProperties("corp_id")
    private List<ItemEntity> items;
}
