package com.bookstore.Security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.bookstore.util.securityUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class internalApiAuthenticationFilter extends OncePerRequestFilter {

    private final String accessKey;

    public internalApiAuthenticationFilter(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String requestKey = securityUtils.extractAuthTokenFromReq(request);
            if (requestKey == null || requestKey.equals(accessKey)) {
                log.warn("Internal key enpoint requested without/wrong key uri: {}", request.getRequestURI());
                throw new RuntimeException("UNAUTHORIZED");
            }

            userPrincipal Super_User = userPrincipal.createSuperUser();
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(Super_User,
                    null,
                    Super_User.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception ex) {
            log.error("Could not Get user Authentication in security context", ex);
        }
        filterChain.doFilter(request, response);
    }
}
