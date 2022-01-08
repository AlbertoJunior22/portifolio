package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.factories;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants.AuthenticationMessage;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants.DatabaseMessage;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.exceptions.DefaultBusinessException;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IMessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ExceptionFactory {

    @Autowired
    private LocaleMessageFactory localeMessageFactory;

    public DefaultBusinessException throwDataBase(DatabaseMessage constant) {
        return retrieveException(constant);
    }

    public DefaultBusinessException throwAuthentication(AuthenticationMessage constant) {
        return retrieveException(constant);
    }

    private DefaultBusinessException retrieveException(IMessageEnum msg) {
        return new DefaultBusinessException(localeMessageFactory.create(msg, "Internal Server Error"));
    }
}
