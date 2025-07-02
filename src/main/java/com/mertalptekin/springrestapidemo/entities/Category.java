package com.mertalptekin.springrestapidemo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "category")
    private List<Product> products;

}

// NOT: FetchType.Persist hiç eklemezsek default type oluyor

// Lazy FetchType: Ürünler sadece Category çağrıldığında değil, ürünler çağrıldığında da yüklenir.
//  CascadeType.ALL: Category silindiğinde, içindeki ürünler de silinir.
// CascadeType.MERGE: Category güncellendiğinde, içindeki ürünler de güncellenir.
// CascadeType.PERSIST: Category kaydedildiğinde, içindeki ürünler de kaydedilir.
// CascadeType.REMOVE: Category silindiğinde, içindeki ürünler de silinir.
// CascadeType.DETACH : Category'den ayrıldığında, içindeki ürünler de ayrılır.
// One Category Has Many products-> OneToMany