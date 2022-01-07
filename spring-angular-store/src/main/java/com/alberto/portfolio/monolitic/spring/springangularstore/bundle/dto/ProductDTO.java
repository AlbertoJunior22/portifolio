package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ProductDTO implements IDTO {

    private Long id;

    @NotEmpty
    private String name;
    private Double price;
    private Boolean available;

    @JsonIgnore
    private Long qtd;
}
