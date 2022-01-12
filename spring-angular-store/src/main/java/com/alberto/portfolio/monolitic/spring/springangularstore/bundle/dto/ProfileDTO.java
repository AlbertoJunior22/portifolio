package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IDTO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class ProfileDTO implements GrantedAuthority, IDTO {

    private Long id;
    private String authority;

}
