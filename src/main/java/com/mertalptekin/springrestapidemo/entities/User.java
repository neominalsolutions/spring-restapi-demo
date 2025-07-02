package com.mertalptekin.springrestapidemo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false,length = 8)
    private String password;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
