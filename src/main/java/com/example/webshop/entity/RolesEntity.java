package com.example.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class RolesEntity implements GrantedAuthority{
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "rolesIdSeq", sequenceName = "roles_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolesIdSeq")
    private Long Id;

    @Column(name = "role", nullable = false)
    private String role;

//    @ManyToOne
//    @JoinColumn(name = "account_id")
//    private AccountEntity account_id;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("roles")
    private List<AccountEntity> accounts;

    @Override
    public String getAuthority() {
        return getRole();
    }

}
