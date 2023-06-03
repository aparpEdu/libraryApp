package org.library.cloud;

import org.junit.jupiter.api.Test;
import org.library.author.Author;
import org.library.book.ElectronicBook;
import org.library.book.Genre;
import org.library.country.Country;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CloudHelperTest {

    @Test
    void shouldReturnTrueWhenEBookDataPresent() {
        ElectronicBook book = new ElectronicBook();
        book.setTitle("Yep");
        book.setIsbn("1231231aDs");
        book.setReadingLink("www.yep.com");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        book.setAuthors(Set.of(author));
        book.setGenres(Set.of(Genre.ROMANCE));
        boolean isDataPresentInBook = CloudHelper.bookDataPresent(book);
        assertTrue(isDataPresentInBook);
    }
    @Test
    void shouldReturnFalseWhenEBookLinkNotPresent() {
        ElectronicBook book = new ElectronicBook();
        book.setTitle("Yep");
        book.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        book.setAuthors(Set.of(author));
        book.setGenres(Set.of(Genre.ROMANCE));
        boolean isDataPresentInBook = CloudHelper.bookDataPresent(book);
        assertFalse(isDataPresentInBook);
    }

}