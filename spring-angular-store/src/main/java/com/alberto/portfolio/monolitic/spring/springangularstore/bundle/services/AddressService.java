package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.AddressDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Address;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<AddressRepository, Address, AddressDTO> {
}
