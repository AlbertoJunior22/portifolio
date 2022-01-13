package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    protected Long id;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedDate = new Date();
    protected String createdBy = "system";
    protected String alteredBy = "system";

}
