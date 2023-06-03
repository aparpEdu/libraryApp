package org.library.checkout;

import org.library.user.User;

public class LoanDelay {
    public static void postponeReturn(User user, LoanedBook loanedBook, int numberOfDaysForDelay){
        if(user.isLoggedIn()){
            if(loanedBook.getDaysDelayed() != 14){
                if(user.getUsername().equals(LoanedBooks.getInstance().getBorrowedBooksByUsers().get(loanedBook))){
                    if(numberOfDaysForDelay + loanedBook.getDaysDelayed() >14){
                        System.out.println("Cannot Postpone with that many days! Delay days left: "+(14- loanedBook.getDaysDelayed()));
                    }else{
                        LoanedBooks.getInstance().getBorrowedBooksByUsers().remove(loanedBook);
                        LoanHelper.adjustReturnDate(loanedBook, numberOfDaysForDelay);
                        LoanedBooks.getInstance().getBorrowedBooksByUsers().put(loanedBook,user.getUsername());
                        System.out.println("Loan successfully extended with "+numberOfDaysForDelay +" days");
                    }
                }

            }else{
                System.out.println("You have made us wait long enough!");
            }
        }else{
            System.out.println("User not logged in");
        }
    }
}
