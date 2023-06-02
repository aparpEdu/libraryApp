package org.library.bookmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.author.Author;
import org.library.book.Book;
import org.library.book.Genre;

import javax.print.attribute.standard.Copies;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CopiesManagerImplTest {

    @BeforeEach
    void setUp() {
        StackedBooks.getInstance().getStackOfBooks().clear();
    }

    @Test
    void shouldReturnNumberOfAvailableCopies() {
        CopiesManagerImpl copiesManager = new CopiesManagerImpl();
        Book firstBook = new Book();
        firstBook.setTitle("Top Gear 101");
        firstBook.setIsbn("123");
        Book secondBook = new Book();
        secondBook.setTitle("Top Gear 101");
        secondBook.setIsbn("123");
        StackedBooks.getInstance().getStackOfBooks().add(firstBook); //adding first copy
        StackedBooks.getInstance().getStackOfBooks().add(secondBook); //adding second copy
        int expectedNumberOfAvailableCopies = 2;
        int numberOfAvailableCopies = copiesManager.getNumberOfAvailableCopies(firstBook);
        assertEquals(expectedNumberOfAvailableCopies,numberOfAvailableCopies);
    }
}