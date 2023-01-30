package com.bookstore.util;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class securityUtils {
    public static final String ROLE_PREFIX = "ROLE_";
    // Spring security expects everything to begin with ROLE_ for things like hasRole()

    public static SimpleGrantedAuthority convertToAuthority(String role) {
        String formatRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;
        return new SimpleGrantedAuthority(formatRole);
    }
}
