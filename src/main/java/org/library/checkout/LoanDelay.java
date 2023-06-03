package org.library.checkout;

import org.library.user.User;

public class LoanDelay {
    public static void postponeReturn(User user, LoanedBook loanedBook, int numberOfDaysForDelay){
        if(user.isLoggedIn()){
            if(loanedBook.getDaysDelayed() != 14){
                if(user.getUsername().equals(LoanedBooks.getInstance().getBorrowedBooksByUsers().get(loanedBook))){
                    if(numberOfDaysForDelay + loanedBook.getDaysDelayed() >14){
                        System.out.println("Cannot Postpone with that many days!");
                    }else{
                        LoanHelper.adjustReturnDate(loanedBook, numberOfDaysForDelay);
                        System.out.println("Loan successfully extended with "+numberOfDaysForDelay +" days");
                    }
                }
            }
        }
    }
}
