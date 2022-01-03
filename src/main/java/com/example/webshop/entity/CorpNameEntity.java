package com.example.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "corpname")
public class CorpNameEntity {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "corpnameIdSeq", sequenceName = "corpname_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "corpnameIdSeq")
    private Long Id;
}
