package org.library.cloud;

import org.library.book.ElectronicBook;
import org.library.system.UserBookHistoryHelper;
import org.library.user.User;

public class ElectronicReader {
    public static void readElectronicBook(User user, ElectronicBook electronicBook) {
        if(user.isLoggedIn()){
            if(CloudHelper.bookDataPresent(electronicBook)){
                UserBookHistoryHelper.addReadElectronicBookToUserHistory(user.getUsername(), electronicBook);
                System.out.println("Book successfully read!");
            }
            else{
                System.out.println("Incorrect book details");
            }
        }else {
            System.out.println("User not logged in");
        }
    }
}
