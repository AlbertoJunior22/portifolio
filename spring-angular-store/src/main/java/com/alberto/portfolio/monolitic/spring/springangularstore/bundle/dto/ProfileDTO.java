package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IDTO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
public class ProfileDTO implements IDTO {

    private Long id;
    private String profile;
    private List<RoleDTO> roles;

}
