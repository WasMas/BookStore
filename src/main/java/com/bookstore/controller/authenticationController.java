package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.services.authenticationServiceInt;
import com.bookstore.services.userServiceInt;
import com.bookstore.models.users;

@RestController
@RequestMapping("/api/authentication") // pre-path
public class authenticationController {
    @Autowired
    private authenticationServiceInt authenticationService;

    @Autowired
    private userServiceInt userService;

    @PostMapping("sign-up")
    public ResponseEntity<users> signUp(@RequestBody users user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUsers(user), HttpStatus.CREATED);
    }
    
    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody users user) {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user),
                HttpStatus.OK);
    }
}