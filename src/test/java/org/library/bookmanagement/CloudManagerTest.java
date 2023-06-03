package org.library.bookmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.author.Author;
import org.library.book.ElectronicBook;
import org.library.book.Genre;
import org.library.country.Country;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CloudManagerTest {

    @BeforeEach
    void setUp() {
        CloudBooks.getInstance().getBooksInCloud().clear();
    }

    @Test
    void bookShouldBeAddedToCloudWhenDataPresent() {
        ElectronicBook book = new ElectronicBook(); //creating a new book
        book.setTitle("Yep"); //setting up data
        book.setIsbn("1231231aDs");
        book.setReadingLink("www.yep.com");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        book.setAuthors(Set.of(author));
        book.setGenres(Set.of(Genre.ROMANCE));
        CloudManager.addElectronicBook(book); // adding example book
        boolean isBookAdded = CloudManager.findElectronicBookByIsbn(book.getIsbn()).isPresent();
        assertTrue(isBookAdded);
    }
    @Test
    void bookShouldNotBeAddedToCloudWhenNoDataPresent() {
        ElectronicBook book = new ElectronicBook(); //creating a new book
        book.setTitle("Yep"); //setting up data
        book.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        book.setAuthors(Set.of(author));
        book.setGenres(Set.of(Genre.ROMANCE));
        CloudManager.addElectronicBook(book); // adding example book
        boolean isBookAdded = CloudManager.findElectronicBookByIsbn(book.getIsbn()).isPresent();
        assertFalse(isBookAdded);
    }
    @Test
    void eBookShouldBeFoundToWhenCorrectIsbnInputGiven() {
        ElectronicBook book = new ElectronicBook(); //creating a new book
        //setting up data
        book.setTitle("Yep");
        book.setIsbn("1231231aDs");
        CloudBooks.getInstance().getBooksInCloud().add(book); // adding example book
        boolean foundBook = CloudManager.findElectronicBookByIsbn(book.getIsbn()).isPresent();
        assertTrue(foundBook);
    }
}