package org.library.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.bookmanagement.StackedBooks;

import static org.junit.jupiter.api.Assertions.*;

class SearchBookTest {

    @BeforeEach
    void setUp() {
        StackedBooks.getInstance().getStackOfBooks().clear();
    }

    @Test
    void searchBooksByTitle() {
    }

    @Test
    void searchBooksByGenre() {
    }

    @Test
    void searchBooksByTags() {
    }

    @Test
    void searchBooksByAuthorFirstName() {
    }

    @Test
    void searchBooksByAuthorLastName() {
    }
}