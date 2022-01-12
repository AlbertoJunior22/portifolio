package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class RoleDTO implements IDTO, GrantedAuthority {

    private Long id;
    private String name;
    private Boolean removible;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return name;
    }
}
