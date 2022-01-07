package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IMessageEnum;

public enum BusinessDatabaseMessage implements IMessageEnum {

    notFound("exception.database.notfound"),
    noRecordsFound("exception.database.norecordsfound");

    private String key;

    BusinessDatabaseMessage(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
