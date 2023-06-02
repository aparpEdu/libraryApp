package org.library.author;

import lombok.Getter;
import org.library.country.Country;

import java.time.LocalDate;
@Getter
public class Author {
    private final String name;
    private final Country countryOfBirth;
    private final LocalDate dateOfBirth;
    private final LocalDate dateOfPassing;

    private Author(String name, Country countryOfBirth, LocalDate dateOfBirth, LocalDate dateOfPassing) {
        this.name = name;
        this.countryOfBirth = countryOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.dateOfPassing = dateOfPassing;
    }
    public static class AuthorBuilder{
        private final String name;
        private final Country countryOfBirth;
        private final LocalDate dateOfBirth;
        private LocalDate dateOfPassing;

        public AuthorBuilder(String name, Country countryOfBirth, LocalDate dateOfBirth) {
            this.name = name;
            this.countryOfBirth = countryOfBirth;
            this.dateOfBirth = dateOfBirth;
        }
        public AuthorBuilder withDateOfPassing(LocalDate dateOfPassing){
            this.dateOfPassing = dateOfPassing;
            return this;
        }
        public Author build(){
            return new Author(name,countryOfBirth,dateOfBirth,dateOfPassing);
        }
    }
}
