package org.library.checkout;

import lombok.Data;
import org.library.book.Book;

import java.time.LocalDate;
@Data
public class LoanedBook {
    private Book book;
    private LocalDate returnDate;
    private int daysDelayed;
}
