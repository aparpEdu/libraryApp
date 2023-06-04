package org.library.bookmanagement;

import org.junit.jupiter.api.Test;
import org.library.author.Author;
import org.library.book.Book;
import org.library.book.ElectronicBook;
import org.library.book.Genre;
import org.library.country.Country;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookManagerTest {

    @Test
    void shouldReturnTrueWhenNoMissingBookData() {
        Book book = new Book();
        book.setTitle("Yep");
        book.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        book.setAuthors(Set.of(author));
        book.setGenres(Set.of(Genre.ROMANCE));
        boolean isDataPresentInBook = BookManager.generalBookDataPresent(book);
        assertTrue(isDataPresentInBook);
    }
    @Test
    void shouldReturnFalseWithMissingBookData() {
        Book book = new Book();
        boolean isDataPresentInBook = BookManager.generalBookDataPresent(book);
        assertFalse(isDataPresentInBook);
    }
    @Test
    void shouldReturnTrueWhenBookHasAReadingLink() {
        ElectronicBook book = new ElectronicBook();
        book.setReadingLink("www.netflix.com");
        boolean readLinkIsAvailable = BookManager.readLinkAvailable(book);
        assertTrue(readLinkIsAvailable);
    }
    @Test
    void shouldReturnFalseWhenBookHasNoReadingLink() {
        ElectronicBook book = new ElectronicBook();
        boolean readLinkIsAvailable = BookManager.readLinkAvailable(book);
        assertFalse(readLinkIsAvailable);
    }
}