package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.repositories;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
