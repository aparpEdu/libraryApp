package org.library.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.author.Author;
import org.library.book.Book;
import org.library.book.Genre;
import org.library.bookmanagement.StackedBooks;
import org.library.country.Country;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SearchBookTest {

    @BeforeEach
    void setUp() {
        StackedBooks.getInstance().getStackOfBooks().clear();
    }

    @Test
    void shouldReturnBooksWithTheTitleGiven() {
        String titleInput = "Garfield";
        Book bookToBeFound = new Book();
        bookToBeFound.setTitle(titleInput);
        StackedBooks.getInstance().getStackOfBooks().add(bookToBeFound);
        Optional<List<Book>> expectedBooks = Optional.of(List.of(bookToBeFound));
        Optional<List<Book>> foundBooks = SearchBook.searchBooksByTitle(titleInput);
        assertEquals(expectedBooks,foundBooks);
    }

    @Test
    void shouldReturnBooksWithGivenGenres() {
        Book bookToBeFound = new Book();
        Set<Genre> genres = Set.of(Genre.ROMANCE);
        bookToBeFound.setGenres(genres);
        StackedBooks.getInstance().getStackOfBooks().add(bookToBeFound);
        Optional<List<Book>> expectedBooks = Optional.of(List.of(bookToBeFound));
        Optional<List<Book>> foundBooks = SearchBook.searchBooksByGenre(genres);
        assertEquals(expectedBooks,foundBooks);
    }

    @Test
    void shouldReturnBooksWithGivenTags() {
        Book bookToBeFound = new Book();
        Set<String> tags = Set.of("18+");
        bookToBeFound.setTags(tags);
        StackedBooks.getInstance().getStackOfBooks().add(bookToBeFound);
        Optional<List<Book>> expectedBooks = Optional.of(List.of(bookToBeFound));
        Optional<List<Book>> foundBooks = SearchBook.searchBooksByTags(tags);
        assertEquals(expectedBooks,foundBooks);
    }

    @Test
    void shouldReturnBooksWithGivenAuthorFirstName() {
        Book bookToBeFound = new Book();
        String firstName = "Francis";
        Author author = new Author.AuthorBuilder(firstName,"Storm", Country.FRANCE, LocalDate.now())
                .withDateOfPassing(LocalDate.now().plusDays(3))
                .build();
        bookToBeFound.setAuthors(Set.of(author));
        StackedBooks.getInstance().getStackOfBooks().add(bookToBeFound);
        Optional<List<Book>> expectedBooks = Optional.of(List.of(bookToBeFound));
        Optional<List<Book>> foundBooks = SearchBook.searchBooksByAuthorFirstName(firstName);
        assertEquals(expectedBooks,foundBooks);
    }

    @Test
    void shouldReturnBooksWithGivenAuthorLastName() {
        Book bookToBeFound = new Book();
        String lastName = "Francis";
        Author author = new Author.AuthorBuilder("Francis",lastName, Country.FRANCE, LocalDate.now()).build();
        bookToBeFound.setAuthors(Set.of(author));
        StackedBooks.getInstance().getStackOfBooks().add(bookToBeFound);
        Optional<List<Book>> expectedBooks = Optional.of(List.of(bookToBeFound));
        Optional<List<Book>> foundBooks = SearchBook.searchBooksByAuthorLastName(lastName);
        assertEquals(expectedBooks,foundBooks);
    }
}