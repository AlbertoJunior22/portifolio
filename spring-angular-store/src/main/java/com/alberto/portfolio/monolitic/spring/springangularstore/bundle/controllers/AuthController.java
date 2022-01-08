package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.controllers;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.LoginDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<?> auth(@Valid @RequestBody LoginDTO login) {
        return ResponseEntity.ok(service.authenticate(login));
    }

}
