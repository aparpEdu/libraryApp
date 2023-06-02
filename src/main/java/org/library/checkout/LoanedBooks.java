package org.library.checkout;

import lombok.Getter;
import lombok.Setter;
import org.library.book.ElectronicBook;
import org.library.book.PaperBook;

import java.util.Map;

public class LoanedBooks {
    @Getter
    @Setter
    private Map<String, PaperBook> borrowedBooksByUser;
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
