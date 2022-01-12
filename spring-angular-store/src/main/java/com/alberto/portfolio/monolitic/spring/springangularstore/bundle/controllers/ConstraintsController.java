package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.controllers;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants.FieldsConstraints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${v1API}/constraints")
public class ConstraintsController {

    @Autowired
    private FieldsConstraints constraints;

    @GetMapping("/fields")
    public ResponseEntity<?> retrieveFieldsConstraints() {
        return ResponseEntity.ok(constraints);
    }
}
