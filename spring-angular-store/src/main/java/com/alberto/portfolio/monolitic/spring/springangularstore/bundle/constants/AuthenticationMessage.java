package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IMessageEnum;

public enum AuthenticationMessage implements IMessageEnum {

    noUserOrPassword("exception.authentication.nouser.or.password");

    private String key;

    AuthenticationMessage(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
