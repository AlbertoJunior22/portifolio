package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.converters;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;

public class BaseConverter<E, D> implements Converter<E, D> {

    protected Type entityType;
    protected Type dtoType;

    @Autowired
    private ModelMapper mapper;

    public E toEntity(D dto) {
        if (dto != null)
            return mapper.map(dto, entityType);
        return null;
    }

    public D fromEntity(E p) {
        if (p != null)
            return mapper.map(p, dtoType);
        return null;
    }
}
