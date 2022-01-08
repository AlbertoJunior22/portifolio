package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsDTO {

    private PersonDTO person;
    private String token;

}
