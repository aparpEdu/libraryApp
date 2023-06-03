package org.library.checkout;

import org.library.book.Book;
import org.library.bookmanagement.CopiesManagerImpl;
import org.library.user.User;

import java.time.LocalDate;

public class LoanProcess {
    public static void loanUserABook(User user, Book book, LocalDate returnDate){
        if(user.isLoggedIn()){
            CopiesManagerImpl copiesManager = new CopiesManagerImpl();
            if(copiesManager.getNumberOfAvailableCopies(book) > 0){
                if(!LoanManager.doesUserHaveMaxPostponedBook(user)) {
                    LoanManager.addLoanedBookToSystem(user, book, returnDate);
                    System.out.println("User borrowed book successfully");
                }
                else {
                    System.out.println("You have not returned books!");
                }
            }
            else{
                System.out.println("None available copies left");
            }
        }else{
            System.out.println("User not logged in!");
        }
    }
    public static void returnBookFromUser(User user, LoanedBook loanedBook){
        if(user.isLoggedIn()){
            if(LoanHelper.isLoanedBookInSystem(loanedBook)) {
                if (loanedBook.getDaysDelayed() > 14) {
                    System.out.println("You've returned the book late!");
                }
                LoanManager.returnLoanedBook(loanedBook);
                System.out.println("Book successfully returned!");
            }else{
                System.out.println("This book was not borrowed from here!");
            }
        }else {
            System.out.println("User not logged in");
        }
    }
}
