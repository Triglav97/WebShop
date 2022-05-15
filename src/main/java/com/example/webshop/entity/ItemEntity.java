package com.example.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "itemIdSeq", sequenceName = "item_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemIdSeq")
    private Long Id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "picture_name", nullable = false)
    private String picture_name;
    
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonIgnoreProperties("items")
    private CategoryEntity category_id;

    @ManyToOne
    @JoinColumn(name = "corp_id", referencedColumnName = "id")
    @JsonIgnoreProperties("items")
    private CorpEntity corp_id;

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("items")
    private List<AccountEntity> accounts;

    // @Column(name = "")

    //связь с акком (диприкейтед)

//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "cart_items")
//    List<AccountEntity> accounts;
    
    @Override
    public String toString() {
        return "ItemEntity{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", picture_name='" + picture_name + '\'' +
                '}';
    }
}
