package com.bookstore.Security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bookstore.models.role;
import com.bookstore.models.users;
import com.bookstore.util.securityUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class userPrincipal implements UserDetails {

    private long id;
    private String username;
    transient private String password;
    transient private users user; // For Login only, Dont use in JWT
    // transient Specify that the object will not be saved or serialised (converts
    // the object state to serial bytes)

    private Set<GrantedAuthority> authorities;

    public static userPrincipal createSuperUser(){
        Set<GrantedAuthority> authorities= Set.of(securityUtils.convertToAuthority(role.SYSTEM_MANAGER.name()));
        return userPrincipal.builder()
        .id(-1L)
        .username("System_Manager")
        .authorities(authorities)
        .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

}