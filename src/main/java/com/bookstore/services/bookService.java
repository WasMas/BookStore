package com.bookstore.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.models.book;
import com.bookstore.repositories.bookRepositoryInt;

@Service
public class bookService implements bookServiceInt {
    // Recommended way of injecting stuff
    private final bookRepositoryInt bookRepository;

    // @Autowired not needed as we have only use 1 constructor
    public bookService(bookRepositoryInt bookRepository) {
        this.bookRepository = bookRepository;
    }
    // Alternative Way: @Autowired bookRepositoryInt bookRepository;

    @Override
    public book saveBook(book book) {
        book.setCreation_date(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<book> getAllBooks() {
        return bookRepository.findAll();
    }

}
