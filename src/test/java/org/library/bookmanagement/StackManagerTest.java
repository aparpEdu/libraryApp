package org.library.bookmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.author.Author;
import org.library.book.Book;
import org.library.book.Genre;
import org.library.country.Country;
import org.library.exception.MissingBookDataException;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StackManagerTest {

    @BeforeEach
    void setUp() {
        StackedBooks.getInstance().getStackOfBooks().clear();
    }

    @Test
    void bookShouldBeAddedToStackWhenDataPresent() {
        Book book = new Book();
        book.setTitle("Yep");
        book.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        book.setAuthors(Set.of(author));
        book.setGenres(Set.of(Genre.ROMANCE));
        StackManager.addPaperBookToStack(book); // adding example book
        boolean isBookAdded = StackManager.findPaperBookByIsbn(book.getIsbn()).isPresent();
        assertTrue(isBookAdded);
    }
    @Test
    void bookShouldNotBeAddedToStackWhenMissingData() {
        Book book = new Book();
        book.setTitle("Yep");
        book.setIsbn("1231231aDs");
        book.setGenres(Set.of(Genre.ROMANCE));
        StackManager.addPaperBookToStack(book); // adding example book
        boolean isBookAdded = StackManager.findPaperBookByIsbn(book.getIsbn()).isPresent();
        assertFalse(isBookAdded);
    }

    @Test
    void bookShouldBeFoundWhenCorrectIsbnInputGiven() {
        Book book = new Book(); //creating a new book
        //setting up data
        book.setTitle("Yep");
        book.setIsbn("1231231aDs");
        StackedBooks.getInstance().getStackOfBooks().add(book); // adding example book
        boolean foundBook = StackManager.findPaperBookByIsbn(book.getIsbn()).isPresent();
        assertTrue(foundBook);
    }
    @Test()
    void shouldThrowExceptionWhenNoIsbnSetUp() {
        Book book = new Book(); //creating a new book
        assertThrows(MissingBookDataException.class, () -> {
            StackedBooks.getInstance().getStackOfBooks().add(book); // adding example book
            StackManager.findPaperBookByIsbn(book.getIsbn()); //searching for a book without giving isbn
        });
    }


    @Test
    void bookShouldBeRemovedFromStackWhenGivenCorrectData() {
        Book book = new Book(); //creating a new book
        //setting up data
        book.setTitle("Yep");
        book.setIsbn("1231231aDs");
        StackedBooks.getInstance().getStackOfBooks().add(book); //adding example book
        int initialNumberOfBooks =  StackedBooks.getInstance().getStackOfBooks().size();
        StackManager.removeBook(book); //removing given book
        int numberOfBooksAfterRemoval = StackedBooks.getInstance().getStackOfBooks().size();
        assertNotEquals(numberOfBooksAfterRemoval,initialNumberOfBooks);
    }
    @Test
    void bookShouldNotBeRemovedFromStackWhenGivenIncorrectData() {
        Book book = new Book(); //creating a new book
        //setting up data
        book.setTitle("Yep");
        book.setIsbn("1231231aDs");
        StackedBooks.getInstance().getStackOfBooks().add(book); //adding example book
        int initialNumberOfBooks =  StackedBooks.getInstance().getStackOfBooks().size();
        Book anotherBook = new Book();
        anotherBook.setIsbn("22a");
        StackManager.removeBook(anotherBook); //removing given book
        int numberOfBooksAfterRemoval = StackedBooks.getInstance().getStackOfBooks().size();
        assertEquals(numberOfBooksAfterRemoval,initialNumberOfBooks);
    }
}