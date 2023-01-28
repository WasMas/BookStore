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
@Table(name = "books")
public class books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_book;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "Description", nullable = false, length = 1500)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "creation date", nullable = false)
    private LocalDateTime creation_date;

}
