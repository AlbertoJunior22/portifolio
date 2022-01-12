package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredentialsDTO {

    private PersonDTO person;
    private String tokenType = "Bearer";
    private String token;

    public CredentialsDTO(PersonDTO person) {
        this.person = person;
    }

}
