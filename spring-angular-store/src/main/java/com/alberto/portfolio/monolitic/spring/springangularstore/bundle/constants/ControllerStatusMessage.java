package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IMessageEnum;

public enum ControllerStatusMessage implements IMessageEnum {
    deleteRecordSuccessful("status.controller.delete.record.successful"),
    differenteIdBetweenParameterAndBody("status.controller.id.different.between.parameter.body");

    private String key;

    ControllerStatusMessage(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
