package com.bookstore.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.models.role;
import com.bookstore.models.users;

public interface userRepositoryInt extends JpaRepository<users, Long> {

    Optional<users> findByUsername(String username); // no need to fill this method

    @Modifying // we gonna modify data
    @Query("UPDATE users SET role = :role WHERE username = :username ") // :role to specify the param
    void updateRole(@Param("username") String username, @Param("role") role role);

}
