package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

@Entity
@Data
public class Role extends BaseEntity  implements GrantedAuthority {

    private String name;
    private Boolean removible;

    @Override
    public String getAuthority() {
        return name;
    }
}
