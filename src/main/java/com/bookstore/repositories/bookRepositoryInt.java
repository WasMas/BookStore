package com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.models.book;

public interface bookRepositoryInt extends JpaRepository<book, Long> { 
    
}
