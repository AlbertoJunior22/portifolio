package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.controllers;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.ProfileDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services.ProfileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController extends BaseController<ProfileService, ProfileDTO> {
}
