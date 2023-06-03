package org.library.bookmanagement;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.library.book.ElectronicBook;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CloudBooksTest {

    @BeforeEach
    void setUp(){
        CloudBooks.getInstance().getBooksInCloud().clear();
    }
    @Test
    public void shouldBeAbleToMakeOnlyOneInstance() {
        CloudBooks firstInstance = CloudBooks.getInstance();
        CloudBooks secondInstance = CloudBooks.getInstance();
        ElectronicBook electronicBook = new ElectronicBook();
        electronicBook.setReadingLink("www.france2.fr");
        electronicBook.setTitle("Galactic Football");
        firstInstance.setBooksInCloud(Set.of(electronicBook)); //changing Set in firstInstance
        assertEquals(firstInstance, secondInstance);
    }
}