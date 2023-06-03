package org.library.system;

import lombok.Getter;
import lombok.Setter;
import org.library.book.ElectronicBook;

import java.util.HashMap;
import java.util.Map;

public class UserBookHistory {
    @Getter
    @Setter
    private Map<String, ElectronicBook> readElectronicBooksByUser = new HashMap<>();

    private static UserBookHistory  instance = null;

    public static UserBookHistory getInstance(){
        if(instance == null){
            instance = new UserBookHistory();
        }
        return instance;
    }
}
