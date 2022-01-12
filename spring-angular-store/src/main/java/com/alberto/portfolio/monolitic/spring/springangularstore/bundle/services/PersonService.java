package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.PersonDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Person;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.repositories.PersonRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService extends BaseService<PersonRepository, Person, PersonDTO> {

    @EventListener(ApplicationReadyEvent.class)
    public void afterInjection() {
        super.entityType = Person.class;
        super.dtoType = PersonDTO.class;
    }

    public PersonDTO retrievePersonByLogin(String login) {
        Optional<Person> p = repository.findPersonByLogin(login);
        if (p.isPresent())
            return fromEntity(p.get());
        throw new UsernameNotFoundException("User not found: " + login);
    }

    @Override
    public PersonDTO create(PersonDTO dto) {
        dto.setProfiles(null);
        dto.setPassword(
            new BCryptPasswordEncoder().encode(dto.getPassword())
        );
        return super.create(dto);
    }
}
