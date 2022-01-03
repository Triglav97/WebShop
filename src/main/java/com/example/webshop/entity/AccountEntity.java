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
@Table(name = "account")
public class AccountEntity {
    @javax.persistence.Id
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account_id")
    private List<RolesEntity> roles;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account_id")
    private PasswordEntity password;

    @ManyToMany
    @JoinTable(
            name = "user_items",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> cart_items;

    public void setCart_items(List<ItemEntity> cart_items) {
        this.cart_items = cart_items;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "Id=" + Id +
                ", user_name='" + name + '\'' +
                ", telephone_num='" + telephone_num + '\'' +
                ", cart_items=" + cart_items +
                '}';
    }
}
