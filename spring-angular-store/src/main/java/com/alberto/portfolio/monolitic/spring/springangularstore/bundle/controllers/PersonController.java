package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.controllers;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.PersonDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${v1API}/person")
public class PersonController extends BaseController<PersonService, PersonDTO> {
}
