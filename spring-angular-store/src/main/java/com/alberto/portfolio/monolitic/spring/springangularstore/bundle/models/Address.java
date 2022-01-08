package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Address extends BaseEntity {

    private String street;
    private Integer number;
    private String district;
    private String city;
    private String zipCode;

    @Column(name = "person_id")
    private Long personId;

}
