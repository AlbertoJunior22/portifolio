package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.repositories;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
