package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Product implements IEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    private Boolean available;
    private Long qtd;

}
