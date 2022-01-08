package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("fields.constraints")
public class FieldsConstraints {

    private int passwordMinLength;
    private int loginMinLength;
    private int nameMinLength;

}
