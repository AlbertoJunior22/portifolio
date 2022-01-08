package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces;

public interface Converter<T, F> {

    public T toEntity(F data);
    public F fromEntity(T data);

}
