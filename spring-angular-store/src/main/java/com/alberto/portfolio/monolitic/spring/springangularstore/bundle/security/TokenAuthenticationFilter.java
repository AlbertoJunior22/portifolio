package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.security;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants.ApplicationConstants;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.CredentialsDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.UserDetailsDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services.AuthService;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services.PersonService;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getTokenFromHeader(request);
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        if (tokenService.isValid(token))
            authenticate(token);

        filterChain.doFilter(request, response);
    }

    private void authenticate(String token) {
        long id = tokenService.getTokenId(token);
        UserDetails user = authService.loadUserDetailsById(id);

        UsernamePasswordAuthenticationToken userPassToken =
                new UsernamePasswordAuthenticationToken(user,
                        null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(userPassToken);
    }

    private String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty() || !token.startsWith(ApplicationConstants.BEARER_TOKEN_TYPE))
            return null;

        int bearerLen = (ApplicationConstants.BEARER_TOKEN_TYPE + " ").length();
        return token.substring(bearerLen, token.length());
    }

}
