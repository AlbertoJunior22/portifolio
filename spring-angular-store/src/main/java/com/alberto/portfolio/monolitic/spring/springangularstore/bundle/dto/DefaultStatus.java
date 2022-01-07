package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto;

import lombok.Data;

@Data
public class DefaultStatus {

    private Integer code;
    private String message;
    private Boolean success;

    private DefaultStatus(Integer code, String message, Boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public static DefaultStatusDTOBuilder builder() {
        return new DefaultStatusDTOBuilder();
    }

    public static class DefaultStatusDTOBuilder {
        private Integer code;
        private String message;
        private Boolean success;

        public DefaultStatusDTOBuilder code(Integer code) {
            this.code = code;
            return this;
        }

        public DefaultStatusDTOBuilder message(String message) {
            this.message = message;
            return this;
        }

        public DefaultStatusDTOBuilder success(Boolean success) {
            this.success = success;
            return this;
        }

        public DefaultStatus build() {
            return new DefaultStatus(code, message, success);
        }

    }

}
