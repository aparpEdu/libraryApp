package org.library;


import org.library.book.ElectronicBook;

public class LibraryApp
{
    public static void main(String[] args) {
        ElectronicBook electronicBook = new ElectronicBook();
        electronicBook.setReadingLink("dd");
        System.out.println(electronicBook);
    }
}

