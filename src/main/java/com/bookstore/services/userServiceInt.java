package com.bookstore.services;

import java.util.Optional;

import com.bookstore.models.users;

public interface userServiceInt {
    users saveUsers(users user);

    public Optional<users> findByUsername(String username);

    public void makeAdmin(String username);
}
