package com.api.filmeteca.enums;

public enum ParamApiEnum {

    KEY_API("api_key=d7251e004d1f3faea8a9b0f9405646b6"),
    LANGUAGE_PT_BR("language=pt-BR");

    private String config;

    private ParamApiEnum(String config) {
        this.setConfig(config);
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

}
