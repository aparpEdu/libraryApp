package org.library.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.author.Author;
import org.library.book.Book;
import org.library.book.Genre;
import org.library.bookmanagement.StackedBooks;
import org.library.country.Country;
import org.library.user.User;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LoanManagerTest {

    @BeforeEach
    void setUp() {
        LoanedBooks.getInstance().getBorrowedBooksByUsers().clear();
    }

    @Test
    void shouldAddLoanedBookToSystemWhenDataPresent() {
        Book book = new Book(); //book for borrowing
        book.setTitle("Life with Louie");
        book.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        book.setAuthors(Set.of(author));
        book.setGenres(Set.of(Genre.ROMANCE));
        User userBorrowing = new User();
        userBorrowing.setUsername("andyAnderson");
        int numberOfLoanedBooksBeforeAdding = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        LoanManager.addLoanedBookToSystem(userBorrowing, book, LocalDate.now()); //adding loaned book to system
        int numberOfLoanedBooksAfterAdding = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        assertNotEquals(numberOfLoanedBooksBeforeAdding,numberOfLoanedBooksAfterAdding);
    }
    @Test
    void shouldNotAddLoanedBookToSystemWhenDataNotPresent() {
        Book book = new Book(); //book for borrowing
        book.setTitle("Life with Louie");
        book.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        book.setAuthors(Set.of(author));
        User userBorrowing = new User();
        userBorrowing.setUsername("andyAnderson");
        int numberOfLoanedBooksBeforeAdding = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        LoanManager.addLoanedBookToSystem(userBorrowing, book, LocalDate.now()); //adding loaned book to system
        int numberOfLoanedBooksAfterAdding = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        assertEquals(numberOfLoanedBooksBeforeAdding,numberOfLoanedBooksAfterAdding);
    }

    @Test
    void shouldReturnedBorrowedBookBackToTheStacks() {
        int numberOfBooksInStackBeforeReturn = StackedBooks.getInstance().getStackOfBooks().size();
        Book bookForBorrowing = new Book();
        bookForBorrowing.setTitle("Life with Louie");
        LoanedBook loanedBook = new LoanedBook();
        loanedBook.setBook(bookForBorrowing);
        User borrowingUser = new User();
        borrowingUser.setUsername("Alfred");
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,borrowingUser.getUsername());//adding book to loaned books
        int numberOfBooksInLoanedBooksBeforeReturn = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        LoanManager.returnLoanedBook(loanedBook);
        int numberOfBooksInStackAfterReturn = StackedBooks.getInstance().getStackOfBooks().size();
        int numberOfBooksInLoanedBooksAfterReturn = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        assertNotEquals(numberOfBooksInStackBeforeReturn,numberOfBooksInStackAfterReturn);
        assertNotEquals(numberOfBooksInLoanedBooksBeforeReturn,numberOfBooksInLoanedBooksAfterReturn);
    }

    @Test
    void shouldReturnTrueWhenUserHasMaxPostponedDelay() {
        Book bookForBorrowing = new Book();
        bookForBorrowing.setTitle("Life with Louie");
        LoanedBook loanedBook = new LoanedBook();
        loanedBook.setBook(bookForBorrowing);
        loanedBook.setDaysDelayed(14);
        User borrowingUser = new User();
        borrowingUser.setUsername("Alfred");
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,borrowingUser.getUsername());
        boolean isUserOverLimit = LoanManager.doesUserHaveMaxPostponedBook(borrowingUser);
        assertTrue(isUserOverLimit);
    }
    @Test
    void shouldReturnFalseWhenUserHasNotMaxPostponedDelay() {
        Book bookForBorrowing = new Book();
        bookForBorrowing.setTitle("Life with Louie");
        LoanedBook loanedBook = new LoanedBook();
        loanedBook.setBook(bookForBorrowing);
        loanedBook.setDaysDelayed(13);
        User borrowingUser = new User();
        borrowingUser.setUsername("Alfred");
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,borrowingUser.getUsername());
        boolean isUserOverLimit = LoanManager.doesUserHaveMaxPostponedBook(borrowingUser);
        assertFalse(isUserOverLimit);
    }
}