package org.library.checkout;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class LoanedBooks {
    @Getter
    @Setter
    private Map<LoanedBook, String> borrowedBooksByUsers = new HashMap<>();

    private static LoanedBooks instance = null;
    private LoanedBooks(){}

    public static LoanedBooks getInstance(){
        if(instance == null){
            instance = new LoanedBooks();
        }
        return instance;
    }
}
