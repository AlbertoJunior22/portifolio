package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.factories;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants.BusinessDatabaseMessage;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.exceptions.DefaultBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ExceptionFactory {

    @Autowired
    private MessageSource messageSource;

    public DefaultBusinessException throwDataBase(BusinessDatabaseMessage constant) {
        return new DefaultBusinessException(
                messageSource.getMessage(constant.getKey(), null,
                        "Default Message", LocaleContextHolder.getLocale()));
    }
}
