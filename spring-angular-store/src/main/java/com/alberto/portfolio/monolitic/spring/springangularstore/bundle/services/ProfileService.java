package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.ProfileDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Profile;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.repositories.ProfileRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ProfileService extends BaseService<ProfileRepository, Profile, ProfileDTO> {

    @EventListener(ApplicationReadyEvent.class)
    public void afterInjection() {
        super.entityType = Profile.class;
        super.dtoType = ProfileDTO.class;
    }

}
