package org.library.system;

import org.library.book.ElectronicBook;
import org.library.checkout.LoanedBook;

public class UserBookHistoryHelper {

        public static void  addReadElectronicBookToUserHistory(String username, ElectronicBook electronicBook){
        if(username != null) {
            UserBookHistory.getInstance().getReadElectronicBooksByUser().put(electronicBook, username);
        }
        else {
            System.out.println("No user given");
        }
    }
    public static void addLoanedBookToUserHistory(String username, LoanedBook loanedBook){
        if(username !=null){
            UserBookHistory.getInstance().getEveryLoanedBookByUser().put(loanedBook, username);
        }
        else{
            System.out.println("No user given!");
        }
    }
}
