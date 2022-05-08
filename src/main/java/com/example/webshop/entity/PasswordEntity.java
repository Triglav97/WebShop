package com.example.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "password")
public class PasswordEntity {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "passwordIdSeq", sequenceName = "password_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passwordIdSeq")
    private Long Id;

    @Column(name = "password", nullable = false)
    private String pass;

    @OneToOne
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties("password")
    private AccountEntity account_id;
}
