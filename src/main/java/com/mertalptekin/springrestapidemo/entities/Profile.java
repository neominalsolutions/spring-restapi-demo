package com.mertalptekin.springrestapidemo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lang;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    // Profili kullanan hesap

}
