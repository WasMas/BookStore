package com.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.services.userServiceInt;

@RestController
@RequestMapping("api/internal")
public class internalApiController {
    private userServiceInt userService;

    public internalApiController(userServiceInt userService) {
        this.userService = userService;
    }

    @PutMapping("make-admin/{username}") // api/internal/make-admin/{username}
    public ResponseEntity<?> makeAdmin(@PathVariable String username) {
        userService.makeAdmin(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
