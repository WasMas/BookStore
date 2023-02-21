package com.bookstore.models;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "users") // DataBase Table name (default = className)
public class users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user; // Create an Id as priamry key

    @Column(name = "username", unique = true, nullable = false) // Create a column
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "Created Date", nullable = false)
    private LocalDateTime Date_Created;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role", nullable = false)
    private role role;

    @Transient
    private String token;
}
