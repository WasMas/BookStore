package com.bookstore.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.models.role;
import com.bookstore.models.users;

// @Repository no need cause jpa already have it
public interface userRepositoryInt extends JpaRepository<users, Long> {

    Optional<users> findByUsername(String username);
    // Use Optional so returns false if no username is found
    // The query executed: SELECT * FROM users WHERE username="{username}"

    @Modifying // we gonna modify data
    @Query("UPDATE users SET role = :role WHERE username = :username ")
    // ":role" to get the variable from @Param("role")
    void updateRole(@Param("username") String username, @Param("role") role role);
}
