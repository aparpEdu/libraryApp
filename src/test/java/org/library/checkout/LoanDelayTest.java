package org.library.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.book.Book;
import org.library.user.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanDelayTest {

    @BeforeEach
    void setUp() {
        LoanedBooks.getInstance().getBorrowedBooksByUsers().clear();
    }

    @Test
    void shouldPostponeReturnWhenDelayDaysCorrectAndLoggedIn() {
        User user = new User(); //user for test
        user.setUsername("adidas");
        user.setLoggedIn(true);
        Book book = new Book();// book for borrowing
        book.setTitle("Gumball");
        LoanedBook loanedBook = new LoanedBook();//borrowed book
        loanedBook.setDaysDelayed(0);
        loanedBook.setBook(book);
        loanedBook.setReturnDate(LocalDate.now());
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,user.getUsername());//adding to system borrowed book
        int numberOfDaysToDelayInput = 4;
        LoanDelay.postponeReturn(user,loanedBook, numberOfDaysToDelayInput); //postponing return date
        LocalDate expectedDate =  LocalDate.now().plusDays(4);
        LocalDate postponedDate = loanedBook.getReturnDate();
        assertEquals(expectedDate,postponedDate);
    }
    @Test
    void shouldNotPostponeReturnWhenDelayDaysIncorrect() {
        User user = new User(); //user for test
        user.setUsername("adidas");
        user.setLoggedIn(true);
        Book book = new Book();// book for borrowing
        book.setTitle("Gumball");
        LoanedBook loanedBook = new LoanedBook();//borrowed book
        loanedBook.setDaysDelayed(11);
        loanedBook.setBook(book);
        loanedBook.setReturnDate(LocalDate.now());
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,user.getUsername());//adding to system borrowed book
        int numberOfDaysToDelayInput = 4;
        LoanDelay.postponeReturn(user,loanedBook, numberOfDaysToDelayInput); //postponing return date
        LocalDate expectedDate =  LocalDate.now().plusDays(4);
        LocalDate postponedDate = loanedBook.getReturnDate();
        assertNotEquals(expectedDate,postponedDate);
    }
    @Test
    void shouldNotPostponeReturnWhenNotLoggedIn() {
        User user = new User(); //user for test
        user.setUsername("adidas");
        user.setLoggedIn(false);
        Book book = new Book();// book for borrowing
        book.setTitle("Gumball");
        LoanedBook loanedBook = new LoanedBook();//borrowed book
        loanedBook.setDaysDelayed(11);
        loanedBook.setBook(book);
        loanedBook.setReturnDate(LocalDate.now());
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,user.getUsername());//adding to system borrowed book
        int numberOfDaysToDelayInput = 4;
        LoanDelay.postponeReturn(user,loanedBook, numberOfDaysToDelayInput); //postponing return date
        LocalDate expectedDate =  LocalDate.now().plusDays(4);
        LocalDate postponedDate = loanedBook.getReturnDate();
        assertNotEquals(expectedDate,postponedDate);
    }
    @Test
    void shouldNotPostponeReturnWhenDelayDaysFull() {
        User user = new User(); //user for test
        user.setUsername("adidas");
        user.setLoggedIn(true);
        Book book = new Book();// book for borrowing
        book.setTitle("Gumball");
        LoanedBook loanedBook = new LoanedBook();//borrowed book
        loanedBook.setDaysDelayed(14);
        loanedBook.setBook(book);
        loanedBook.setReturnDate(LocalDate.now());
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,user.getUsername());//adding to system borrowed book
        int numberOfDaysToDelayInput = 4;
        LoanDelay.postponeReturn(user,loanedBook, numberOfDaysToDelayInput); //postponing return date
        LocalDate expectedDate =  LocalDate.now().plusDays(4);
        LocalDate postponedDate = loanedBook.getReturnDate();
        assertNotEquals(expectedDate,postponedDate);
    }
}