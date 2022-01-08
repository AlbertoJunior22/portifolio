package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.converters;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.ConverterCallback;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

public final class ConverterUtil {

    public static <F, T> T Converter(F source, Type to, ConverterCallback<F, T> converterCallback) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(source, to);
    }
}
