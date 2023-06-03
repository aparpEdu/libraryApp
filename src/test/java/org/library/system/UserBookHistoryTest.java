package org.library.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.book.ElectronicBook;
import org.library.user.User;

import static org.junit.jupiter.api.Assertions.*;

class UserBookHistoryTest {
    @BeforeEach
    void setUp(){
        UserBookHistory.getInstance().getReadElectronicBooksByUser().clear();
    }

    @Test
    void shouldBeAbleToMakeOnlyOneInstance() {
     UserBookHistory firstInstance = UserBookHistory.getInstance();
     UserBookHistory secondInstance = UserBookHistory.getInstance();
     ElectronicBook electronicBookRead = new ElectronicBook();
     User user = new User();
     user.setUsername("Alfred");
     firstInstance.getReadElectronicBooksByUser().put(electronicBookRead,user.getUsername());
     assertEquals(firstInstance,secondInstance);
    }
}