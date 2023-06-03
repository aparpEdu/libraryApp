package org.library.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.book.Book;
import org.library.user.User;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanInfoTest {

    @BeforeEach
    void setUp() {
        LoanedBooks.getInstance().getBorrowedBooksByUsers().clear();
    }

    @Test
    void shouldReturnAllLoanedBooksByUserWhenLoggedIn() {
        User user = new User();
        user.setUsername("Garfield");
        user.setLoggedIn(true);
        Book borrowedBook = new Book();
        borrowedBook.setTitle("HearthStone");
        LoanedBook loanedBook = new LoanedBook();
        loanedBook.setReturnDate(LocalDate.now());
        loanedBook.setBook(borrowedBook);
        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook, user.getUsername()); //add loaned book
        //setting up test venue for System.out.println
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        LoanInfo.getAllLoanedBooksByUser(user);//getting output of every return date
        String output = outputStream.toString().trim();
        String expectedOutput =loanedBook.getBook().getTitle()+"| return date: " + LocalDate.now().toString();
        assertEquals(expectedOutput, output);
    }
}