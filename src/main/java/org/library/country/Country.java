package org.library.country;

import lombok.Getter;

public enum Country {
    USA("USA"),
    BULGARIA("Bulgaria"),
    PARAGUAY("Paraguay"),
    FRANCE("France");
    @Getter
    private final String name;
    Country(String name) {
        this.name = name;
    }
}
