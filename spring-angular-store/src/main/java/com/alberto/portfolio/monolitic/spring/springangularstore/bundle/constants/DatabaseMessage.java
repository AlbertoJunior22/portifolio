package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IMessageEnum;

public enum DatabaseMessage implements IMessageEnum {

    notFound("exception.database.notfound"),
    noRecordsFound("exception.database.norecordsfound");

    private String key;

    DatabaseMessage(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
