package org.library.checkout;

import org.junit.jupiter.api.Test;
import org.library.author.Author;
import org.library.book.Book;
import org.library.book.Genre;
import org.library.country.Country;
import org.library.user.User;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LoanHelperTest {

    @Test
    void shouldReturnABookForLoaningWhenBookDataPresent() {
        Book book = new Book(); //book for borrowing
        book.setTitle("Yep");
        book.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        book.setAuthors(Set.of(author));
        book.setGenres(Set.of(Genre.ROMANCE));
        LoanedBook loanedBook = new LoanedBook(); //loaned book
        loanedBook.setBook(book);
        loanedBook.setReturnDate(LocalDate.now());
        Optional<LoanedBook> expectedLoanedBook = Optional.of(loanedBook);
        Optional<LoanedBook> returnedLoanedBook = LoanHelper.getBookForLoaning(book,LocalDate.now()); //converting  book to loaned book
        assertEquals(expectedLoanedBook,returnedLoanedBook);
    }
    @Test
    void shouldNotReturnBookForLoaningWhenBookDataNotPresent() {
        Book book = new Book(); //book for borrowing
        book.setTitle("Yep");
        book.setIsbn("1231231aDs");
        Author author = new Author.AuthorBuilder("Gerald","Blue", Country.FRANCE, LocalDate.now())
                .build(); //author for example
        book.setAuthors(Set.of(author));
        LoanedBook loanedBook = new LoanedBook(); //loaned book
        loanedBook.setBook(book);
        loanedBook.setReturnDate(LocalDate.now());
        Optional<LoanedBook> expectedLoanedBook = Optional.of(loanedBook);
        Optional<LoanedBook> returnedLoanedBook = LoanHelper.getBookForLoaning(book,LocalDate.now()); //converting  book to loaned book
        assertNotEquals(expectedLoanedBook,returnedLoanedBook);
    }

    @Test
    void shouldReturnTrueWhenLoanedBookInSystem() {
        LoanedBook loanedBook = new LoanedBook();
        Book book = new Book();//book to be borrowed
        book.setTitle("Garfield");
        loanedBook.setBook(book);
        User user = new User(); //user borrowing the book
        user.setUsername("DarwinWaterson");
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,user.getUsername()); // putting book in system
        boolean isBookInTheSystem = LoanHelper.isLoanedBookInSystem(loanedBook);
        assertTrue(isBookInTheSystem);
    }
    @Test
    void shouldReturnFalseWhenLoanedBookNotInSystem() {
        LoanedBook loanedBook = new LoanedBook();
        Book book = new Book();//book to be borrowed
        book.setTitle("Garfield");
        loanedBook.setBook(book);
        User user = new User(); //user borrowing the book
        user.setUsername("DarwinWaterson");
        LoanedBook otherBook = new LoanedBook();
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,user.getUsername()); // putting book in system
        boolean isBookInTheSystem = LoanHelper.isLoanedBookInSystem(otherBook);
        assertFalse(isBookInTheSystem);
    }

    @Test
    void shouldAdjustLoanedBookReturnDate() {
        LoanedBook loanedBook = new LoanedBook();
        loanedBook.setReturnDate(LocalDate.now());
        LocalDate returnDateBeforeAdjustment = loanedBook.getReturnDate();
        LoanHelper.adjustReturnDate(loanedBook,2);
        LocalDate returnDateAfterAdjustment = loanedBook.getReturnDate();
        assertTrue(returnDateBeforeAdjustment.isBefore(returnDateAfterAdjustment));
    }
}