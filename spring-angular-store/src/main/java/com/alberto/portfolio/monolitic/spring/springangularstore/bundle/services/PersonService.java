package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.LoginDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.PersonDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.ProductDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Person;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Product;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.repositories.PersonRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<PersonRepository, Person, PersonDTO> {

    @EventListener(ApplicationReadyEvent.class)
    public void afterInjection() {
        super.entityType = Person.class;
        super.dtoType = PersonDTO.class;
    }

    public PersonDTO retrievePersonByLogin(LoginDTO login) {
        Person p = repository.findPersonByLoginAndPassword(login.getLogin(), login.getPassword());
        return fromEntity(p);
    }
}
