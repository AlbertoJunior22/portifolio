package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants.AuthenticationMessage;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.CredentialsDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.LoginDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.PersonDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.factories.ExceptionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private PersonService personService;

    @Autowired
    private ExceptionFactory exceptionFactory;

    public CredentialsDTO authenticate(LoginDTO login) {
        PersonDTO person = personService.retrievePersonByLogin(login);
        if (person == null)
            throw exceptionFactory.throwAuthentication(AuthenticationMessage.noUserOrPassword);
        return new CredentialsDTO(person, "");
    }
}
