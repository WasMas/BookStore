package com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.models.books;

public interface bookRepositoryInt extends JpaRepository<books, Long> { 
    
}
