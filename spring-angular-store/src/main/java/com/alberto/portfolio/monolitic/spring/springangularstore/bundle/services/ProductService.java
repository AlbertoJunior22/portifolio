package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.ProductDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.Product;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.repositories.ProductRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ProductService<T> extends BaseService<ProductRepository, Product, ProductDTO> {

    @EventListener(ApplicationReadyEvent.class)
    public void afterInjection() {
        super.entityType = Product.class;
        super.dtoType = ProductDTO.class;
    }

}
