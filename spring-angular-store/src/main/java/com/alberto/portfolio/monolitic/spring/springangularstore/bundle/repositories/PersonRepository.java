package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.repositories;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findPersonByLoginAndPassword(String login, String password);
    Optional<Person> findPersonByLogin(String name);

}
