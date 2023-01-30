package com.bookstore.Security;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bookstore.models.users;
import com.bookstore.repositories.userRepositoryInt;
import com.bookstore.util.securityUtils;

@Service
public class customUserDetailsService implements UserDetailsService {

    private userRepositoryInt userRepositoryInt;

    public customUserDetailsService(userRepositoryInt userRepositoryInt) {
        this.userRepositoryInt = userRepositoryInt;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        users user = userRepositoryInt.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        Set<GrantedAuthority> authorities = Set.of(securityUtils.convertToAuthority(user.getRole().name()));
        return userPrincipal.builder()
                .user(user).id(user.getId_user())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }

}
