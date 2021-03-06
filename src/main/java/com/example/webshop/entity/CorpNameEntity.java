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
@Table(name = "corpname")
public class CorpNameEntity {
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "corpnameIdSeq", sequenceName = "corpname_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "corpnameIdSeq")
    private Long Id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "corp_id")
    @Column(name = "items")
    @JsonIgnoreProperties("corp_id")
    private List<ItemEntity> items;
}
