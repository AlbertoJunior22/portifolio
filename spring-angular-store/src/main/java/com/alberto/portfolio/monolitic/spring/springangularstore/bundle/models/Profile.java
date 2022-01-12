package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

@Data
@Entity
public class Profile extends BaseEntity implements GrantedAuthority {

    private String authority;

}
