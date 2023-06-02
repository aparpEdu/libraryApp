package org.library.author;

import lombok.Getter;
import org.library.country.Country;

import java.time.LocalDate;
@Getter
public class Author {
    private final String firstName;
    private final String lastName;
    private final Country countryOfBirth;
    private final LocalDate dateOfBirth;
    private final LocalDate dateOfPassing;

    private Author(String firstName, String lastName, Country countryOfBirth, LocalDate dateOfBirth, LocalDate dateOfPassing) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryOfBirth = countryOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.dateOfPassing = dateOfPassing;
    }
    public static class AuthorBuilder{
        private final String firstName;
        private final String lastName;
        private final Country countryOfBirth;
        private final LocalDate dateOfBirth;
        private LocalDate dateOfPassing;

        public AuthorBuilder(String firstName, String lastName, Country countryOfBirth, LocalDate dateOfBirth) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.countryOfBirth = countryOfBirth;
            this.dateOfBirth = dateOfBirth;
        }
        public AuthorBuilder withDateOfPassing(LocalDate dateOfPassing){
            this.dateOfPassing = dateOfPassing;
            return this;
        }
        public Author build(){
            return new Author(firstName, lastName, countryOfBirth,dateOfBirth,dateOfPassing);
        }
    }
}
