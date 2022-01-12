package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.controllers;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.ProductDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${v1API}/product")
public class ProductController extends BaseController<ProductService, ProductDTO> {

}
