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

class LoanProcessTest {

    @BeforeEach
    void setUp() {
        LoanedBooks.getInstance().getBorrowedBooksByUsers().clear(); // clearing all loaned books
    }

    @Test
    void userShouldBeAbleToBorrowABookWhenMeetingCriteria() {
        Book bookForBorrowing = new Book();
        bookForBorrowing.setTitle("Life with Louie");
        bookForBorrowing.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        bookForBorrowing.setAuthors(Set.of(author));
        bookForBorrowing.setGenres(Set.of(Genre.ROMANCE));
        User borrowingUser = new User();
        borrowingUser.setUsername("Alfred");
        borrowingUser.setLoggedIn(true);
        StackedBooks.getInstance().getStackOfBooks().add(bookForBorrowing);// adding book to stack first
        int numberOfLoanedBooksBeforeBorrowing = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        LoanProcess.loanUserABook(borrowingUser,bookForBorrowing, LocalDate.now());
        int numberOfLoanedBooksAfterBorrowing = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        assertTrue(numberOfLoanedBooksBeforeBorrowing<numberOfLoanedBooksAfterBorrowing);
    }
    @Test
    void userShouldNotBeAbleToBorrowABookWhenNotMeetingCriteria() {
        Book bookForBorrowing = new Book();
        bookForBorrowing.setTitle("Life with Louie");
        bookForBorrowing.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        bookForBorrowing.setAuthors(Set.of(author));
        bookForBorrowing.setGenres(Set.of(Genre.ROMANCE));
        User borrowingUser = new User();
        borrowingUser.setUsername("Alfred");
        borrowingUser.setLoggedIn(false);
        StackedBooks.getInstance().getStackOfBooks().add(bookForBorrowing);// adding book to stack first
        int numberOfLoanedBooksBeforeBorrowing = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        LoanProcess.loanUserABook(borrowingUser,bookForBorrowing, LocalDate.now());
        int numberOfLoanedBooksAfterBorrowing = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        assertFalse(numberOfLoanedBooksBeforeBorrowing<numberOfLoanedBooksAfterBorrowing);
    }

    @Test
    void userShouldBeAbleToReturnABookWhenReturningCorrectBookAndLoggedIn() {
        Book bookForBorrowing = new Book();
        bookForBorrowing.setTitle("Life with Louie");
        bookForBorrowing.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        bookForBorrowing.setAuthors(Set.of(author));
        bookForBorrowing.setGenres(Set.of(Genre.ROMANCE));
        LoanedBook loanedBook = new LoanedBook();
        loanedBook.setBook(bookForBorrowing);
        User borrowingUser = new User();
        borrowingUser.setUsername("Alfred");
        borrowingUser.setLoggedIn(true);
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,borrowingUser.getUsername()); //adding loaned book to system
        int numberOfLoanedBooksBeforeReturning = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        LoanProcess.returnBookFromUser(borrowingUser,loanedBook);
        int numberOfLoanedBooksAfterReturning = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        assertTrue(numberOfLoanedBooksBeforeReturning > numberOfLoanedBooksAfterReturning);
    }
    @Test
    void userShouldNotBeAbleToReturnABookWhenReturningIncorrectBook() {
        Book bookForBorrowing = new Book();
        bookForBorrowing.setTitle("Life with Louie");
        bookForBorrowing.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        bookForBorrowing.setAuthors(Set.of(author));
        bookForBorrowing.setGenres(Set.of(Genre.ROMANCE));
        LoanedBook loanedBook = new LoanedBook();
        loanedBook.setBook(bookForBorrowing);
        LoanedBook incorrectBook = new LoanedBook();
        User borrowingUser = new User();
        borrowingUser.setUsername("Alfred");
        borrowingUser.setLoggedIn(true);
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,borrowingUser.getUsername()); //adding loaned book to system
        int numberOfLoanedBooksBeforeReturning = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        LoanProcess.returnBookFromUser(borrowingUser,incorrectBook);
        int numberOfLoanedBooksAfterReturning = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        assertFalse(numberOfLoanedBooksBeforeReturning > numberOfLoanedBooksAfterReturning);
    }
    @Test
    void userShouldNotBeAbleToReturnABookWhenNotLoggedIn() {
        Book bookForBorrowing = new Book();
        bookForBorrowing.setTitle("Life with Louie");
        bookForBorrowing.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        bookForBorrowing.setAuthors(Set.of(author));
        bookForBorrowing.setGenres(Set.of(Genre.ROMANCE));
        LoanedBook loanedBook = new LoanedBook();
        loanedBook.setBook(bookForBorrowing);
        LoanedBook incorrectBook = new LoanedBook();
        User borrowingUser = new User();
        borrowingUser.setUsername("Alfred");
        borrowingUser.setLoggedIn(false);
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,borrowingUser.getUsername()); //adding loaned book to system
        int numberOfLoanedBooksBeforeReturning = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        LoanProcess.returnBookFromUser(borrowingUser,incorrectBook);
        int numberOfLoanedBooksAfterReturning = LoanedBooks.getInstance().getBorrowedBooksByUsers().size();
        assertFalse(numberOfLoanedBooksBeforeReturning > numberOfLoanedBooksAfterReturning);
    }

}