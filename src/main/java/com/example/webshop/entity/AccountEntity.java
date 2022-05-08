package com.example.webshop.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "accountIdSeq", sequenceName = "account_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountIdSeq")
    private Long Id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "tel_num", nullable = false)
    private String telephone_num;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "cart")
    private String item_id;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnoreProperties("accounts")
    private List<RolesEntity> roles;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account_id")
    @JsonIgnoreProperties("account_id")
    private PasswordEntity password;

    @ManyToMany
    @JoinTable(
        name = "account_item",
        joinColumns = @JoinColumn(name = "account_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    @JsonIgnoreProperties("accounts")
    private List<ItemEntity> items;


    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account_id")
    //    private Set<RolesEntity> roles;

    //не хочу делать связь из-за перегруза на бд,
    // будет сделана строка для хранения всех
    // id товаров в корзине

//    @ManyToMany
//    @JoinTable(
//            name = "user_items",
//            joinColumns = @JoinColumn(name = "account_id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id")
//    )
//    private List<ItemEntity> cart_items;


    @Override
    public String toString() {
        return "AccountEntity{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", telephone_num='" + telephone_num + '\'' +
                ", address='" + address + '\'' +
                ", roles=" + roles +
                '}';
    }
}
