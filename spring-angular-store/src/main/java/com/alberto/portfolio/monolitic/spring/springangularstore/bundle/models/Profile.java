package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Profile extends BaseEntity{

    private String profile;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Role.class)
    private List<Role> roles;

}
