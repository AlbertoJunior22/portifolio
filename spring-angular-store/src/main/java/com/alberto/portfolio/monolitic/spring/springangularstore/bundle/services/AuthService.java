package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants.AuthenticationMessage;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.CredentialsDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.PersonDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.factories.ExceptionFactory;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private PersonService personService;

    @Autowired
    private ExceptionFactory exceptionFactory;

    public CredentialsDTO getCredentials(String login) {
        PersonDTO person = personService.retrievePersonByLogin(login);
        if (person == null)
            throw exceptionFactory.throwAuthentication(AuthenticationMessage.noUserOrPassword);
        return new CredentialsDTO(person);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonDTO user = personService.retrievePersonByLogin(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found: " + username);
        return createUserDetails(user);
    }

    public UserDetails loadUserDetailsById(long id) throws UsernameNotFoundException {
        PersonDTO user = personService.retrieveById(id);
        if (user == null)
            throw new UsernameNotFoundException("User not found: " + id);
        return createUserDetails(user);
    }

    private UserDetailsDTO createUserDetails(PersonDTO person) {
        if (person == null) return null;
        UserDetailsDTO dto = new UserDetailsDTO();
        dto.setId(person.getId());
        dto.setUsername(person.getLogin());
        dto.setPassword(person.getPassword());
        dto.setProfiles(person.getProfiles());
        dto.setAccountNonExpired(true);
        dto.setAccountNonLocked(true);
        dto.setCredentialsNonExpired(true);
        return dto;
    }
}
