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
    protected Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedDate;
    protected String createdBy;
    protected String alteredBy;

}
