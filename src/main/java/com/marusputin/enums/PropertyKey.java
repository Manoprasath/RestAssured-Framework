package com.marusputin.enums;

import lombok.Getter;

@Getter
public enum PropertyKey {
    BASE_URI("baseURI");

    private String value;

    PropertyKey(String value) {
        this.value = value;
    }

}
