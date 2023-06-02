package org.library.checkout;

import lombok.Getter;
import lombok.Setter;
import org.library.book.Book;
import org.library.book.ElectronicBook;

import java.util.Map;

public class LoanedBooks {
    @Getter
    @Setter
    private Map<String, Book> borrowedBooksByUser;
    @Getter
    @Setter
    private Map<String, ElectronicBook> readElectronicBooksByUser;
    private static LoanedBooks instance = null;
    private LoanedBooks(){}

    public static LoanedBooks getInstance(){
        if(instance == null){
            instance = new LoanedBooks();
        }
        return instance;
    }
}
