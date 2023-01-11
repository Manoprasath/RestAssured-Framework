package com.marusputin.enums;

public enum TestCategory {
    REGRESSION("regression"),
    SMOKE("smoke"),
    USER_ACCEPTANCE("user_acceptance");

    private String value;

    TestCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
