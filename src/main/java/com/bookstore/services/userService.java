package com.bookstore.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.models.role;
import com.bookstore.models.users;
import com.bookstore.repositories.userRepositoryInt;

@Service
public class userService implements userServiceInt {

    @Autowired
    private userRepositoryInt userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public users saveUsers(users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(role.User);
        user.setDate_Created(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional // Required when executing update/delete query
    public void makeAdmin(String username) {
        userRepository.updateRole(username, role.Admin);
    }

}
