package com.mertalptekin.springrestapidemo.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products") // veritabanı tablo karşılığı
// ORM Object Relational Mappings
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name="name",unique = true)
    private String productName;

    @Column(name = "price")
    private BigDecimal unitPrice;

    @Column(name = "stock")
    private Integer unitsinStock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id") // FK
    private Category category;
}

// @oneToOne, @OneToMany, @manyToOne, @ManyToMany