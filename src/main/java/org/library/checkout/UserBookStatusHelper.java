package org.library.checkout;

import org.library.book.Book;
import org.library.book.ElectronicBook;

public class UserBookStatusHelper {
    public static void mapBorrowedBookToUser(String username, Book paperBook){
        if(username != null) {
            LoanedBooks.getInstance().getBorrowedBooksByUser().put(username, paperBook);
        }
        else {
            System.out.println("No such user");
        }
    }
    public static void  mapReadEbookToUser(String username, ElectronicBook electronicBook){
        if(username != null) {
            LoanedBooks.getInstance().getReadElectronicBooksByUser().put(username, electronicBook);
        }
        else {
            System.out.println("No such user");
        }
    }
}
