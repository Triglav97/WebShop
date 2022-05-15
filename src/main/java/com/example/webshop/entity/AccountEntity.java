package com.example.webshop.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class AccountEntity implements UserDetails{
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnoreProperties("accounts")
    private List<RolesEntity> roles;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account_id", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("account_id")
    private PasswordEntity password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "account_item",
        joinColumns = @JoinColumn(name = "account_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    @JsonIgnoreProperties("accounts")
    private List<ItemEntity> items;


    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return getPassword();
    }
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
