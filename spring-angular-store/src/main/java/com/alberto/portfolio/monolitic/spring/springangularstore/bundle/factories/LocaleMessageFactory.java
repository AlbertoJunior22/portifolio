package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.factories;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.exceptions.DefaultBusinessException;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IMessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LocaleMessageFactory {

    @Autowired
    private MessageSource messageSource;

    public String create(IMessageEnum key, String defaultMessage) {
        return messageSource.getMessage(key.getKey(), null,
                defaultMessage, LocaleContextHolder.getLocale());
    }

    public String create(IMessageEnum key) {
        return messageSource.getMessage(key.getKey(), null,
                "", LocaleContextHolder.getLocale());
    }

}
