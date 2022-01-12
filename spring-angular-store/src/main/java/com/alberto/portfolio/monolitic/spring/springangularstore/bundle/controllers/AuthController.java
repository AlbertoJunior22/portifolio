package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.controllers;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants.ApplicationConstants;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.CredentialsDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.LoginDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services.AuthService;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> auth(@Valid @RequestBody LoginDTO login) {
        UsernamePasswordAuthenticationToken userPass =
                new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword());

        Authentication authentication = authenticationManager.authenticate(userPass);

        String token = tokenService.generateToken(authentication);
        CredentialsDTO credentials = service.getCredentials(login.getLogin());
        credentials.setToken(token);
        credentials.setTokenType(ApplicationConstants.BEARER_TOKEN_TYPE);

        return ResponseEntity.ok(credentials);
    }

}
