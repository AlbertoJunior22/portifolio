package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.repositories;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
