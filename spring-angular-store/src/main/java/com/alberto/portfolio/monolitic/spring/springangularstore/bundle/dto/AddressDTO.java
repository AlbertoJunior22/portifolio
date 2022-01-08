package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IDTO;
import lombok.Data;

@Data
public class AddressDTO implements IDTO {

    private Long id;
    private String street;
    private Integer number;
    private String district;
    private String city;
    private String zipCode;

}
