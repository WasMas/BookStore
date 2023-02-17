package com.bookstore.Security.jwt;

import org.springframework.security.core.Authentication;

import com.bookstore.Security.userPrincipal;
import jakarta.servlet.http.HttpServletRequest;

public interface jwtProviderInt {
    public Authentication getAuthentication(HttpServletRequest request);

    public String generateToken(userPrincipal auth);

    public boolean validateToken(HttpServletRequest request);
}
