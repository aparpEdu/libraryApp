package org.library.author;

import lombok.Data;
import org.library.country.Country;

import java.time.LocalDate;

@Data
public abstract class Author {
    private String name;
    private Country countryOfBirth;
    private LocalDate dateOfBirth;
}
