package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.exceptions;

import org.springframework.context.annotation.PropertySource;

@PropertySource("EXCEPTION.ERRORS")
public class ExceptionsErrors {

    public static String PRODUCT_NOT_FOUND = "Product not found";
    public static String URL_PARAMETER_CANNOT_BE_NULL = "Url parameter(s) cannot be null";
}
