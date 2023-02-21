package com.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.bookstore.Security.userPrincipal;
import com.bookstore.Security.jwt.jwtProviderInt;
import com.bookstore.models.users;

@Service
public class authenticationService implements authenticationServiceInt {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtProviderInt jwtProvider;

    @Override
    public users signInAndReturnJWT(users signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getUsername(), signInRequest.getPassword()));
        userPrincipal userPrincipal = (userPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        users signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }
}
