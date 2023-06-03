package org.library.checkout;

import org.library.user.User;

import java.util.Map;

public class LoanInfo {
    public static void getAllLoanedBooksByUser(User user) {
        if (user.isLoggedIn()) {
            String userInQuestion = user.getUsername();
            for (Map.Entry<LoanedBook, String> entry : LoanedBooks.getInstance().getBorrowedBooksByUsers().entrySet()) {
                LoanedBook loanedBook = entry.getKey();
                String clientName = entry.getValue();
                if (clientName.equals(userInQuestion)) {
                    System.out.println(loanedBook.getBook().getTitle()+"| return date: "+loanedBook.getReturnDate());
                }
            }
        }
    }
}
