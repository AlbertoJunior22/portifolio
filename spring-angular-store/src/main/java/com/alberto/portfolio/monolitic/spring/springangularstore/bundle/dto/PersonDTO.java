package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Address;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Profile;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PersonDTO implements IDTO {

    private Long id;
    private String login;
    private String email;
    private String emailConfirmation;
    private String password;
    private String passwordConfirmation;
    private String name;
    private Date birthday;
    private String identity;
    private ProfileDTO profile;
    private List<AddressDTO> address;

}
