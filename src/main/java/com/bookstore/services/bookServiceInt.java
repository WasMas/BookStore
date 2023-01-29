package com.bookstore.services;

import java.util.List;

import com.bookstore.models.book;

public interface bookServiceInt {
    public book saveBook(book book);

    public void deleteBook(Long id);

    public List<book> getAllBooks();
}
