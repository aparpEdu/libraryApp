package org.library.checkout;

import org.library.book.ElectronicBook;
import org.library.book.PaperBook;

public class UserBookStatusHelper {
    public static void mapBorrowedBookToUser(String username, PaperBook paperBook){
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
