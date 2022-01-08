package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Person extends BaseEntity {

    private String login;
    private String email;
    private String password;
    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthday;
    private String identity;

    @OneToMany(mappedBy = "personId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> address;

}
