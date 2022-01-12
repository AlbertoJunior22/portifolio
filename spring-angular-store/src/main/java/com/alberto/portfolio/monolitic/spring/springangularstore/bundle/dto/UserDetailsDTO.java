package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Profile;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class UserDetailsDTO implements UserDetails {

    private Long id;
    private String password;
    private String username;

    @Getter(AccessLevel.PRIVATE)
    private Boolean accountNonExpired = true;

    @Getter(AccessLevel.PRIVATE)
    private Boolean accountNonLocked = true;

    @Getter(AccessLevel.PRIVATE)
    private Boolean credentialsNonExpired = true;

    @Getter(AccessLevel.PRIVATE)
    private Boolean enabled;

    @Getter(AccessLevel.PRIVATE)
    private List<ProfileDTO> profiles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return profiles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
