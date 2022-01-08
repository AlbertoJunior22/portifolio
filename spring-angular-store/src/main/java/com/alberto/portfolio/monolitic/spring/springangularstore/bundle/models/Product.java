package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Product extends BaseEntity {

    private String name;
    private Double price;
    private Boolean available;
    private Long qtd;

}
