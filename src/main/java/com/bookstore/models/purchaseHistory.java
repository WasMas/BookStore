package com.bookstore.models;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "purchaseHistory")
public class purchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_purchase;

    @Column(name = "id_user", nullable = false)
    private Long id_user;

    @Column(name = "id_book", nullable = false)
    private Long id_book;

    @Column(name = "price", nullable = false)
    private Double price;

    
    @Column(name = "purchaseTime", nullable = false)
    private LocalDateTime purchaseTime;
}
