package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces;

public interface ConverterCallback<F, T> {

    T converter(F from);

}
