package org.library.book;

import lombok.Getter;

public enum Genre {
    FICTION("Fiction"),
    MYSTERY("Mystery"),
    SCI_FI("Sci-Fi"),
    ROMANCE("Romance"),
    FANTASY("Fantasy");

    @Getter
    private final String name;

    Genre(String name) {
        this.name = name;
    }
}
