package org.library.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.book.ElectronicBook;
import org.library.checkout.LoanedBook;
import org.library.user.User;

import static org.junit.jupiter.api.Assertions.*;

class UserBookHistoryHelperTest {

    @BeforeEach
    void setUp() {
        UserBookHistory.getInstance().getReadElectronicBooksByUser().clear();
        UserBookHistory.getInstance().getEveryLoanedBookByUser().clear();
    }

    @Test
    void shouldAddReadBookToUserHistoryWhenGivenUsername() {
        ElectronicBook electronicBook = new ElectronicBook();
        electronicBook.setReadingLink("www.chillZone.com");
        electronicBook.setDownloadLink("www.france.com");
        User user = new User();
        user.setUsername("Jose");
        int numberOfElectronicBooksBeforeAdding = UserBookHistory.getInstance().getReadElectronicBooksByUser().size();
        UserBookHistoryHelper.addReadElectronicBookToUserHistory(user.getUsername(), electronicBook);
        int numberOfElectronicBooksAfterAdding = UserBookHistory.getInstance().getReadElectronicBooksByUser().size();
        assertTrue(numberOfElectronicBooksAfterAdding > numberOfElectronicBooksBeforeAdding);
    }
    @Test
    void shouldNotAddReadBookToUserHistoryWhenNotGivenUsername() {
        ElectronicBook electronicBook = new ElectronicBook();
        electronicBook.setReadingLink("www.chillZone.com");
        electronicBook.setDownloadLink("www.france.com");
        User user = new User();
        int numberOfElectronicBooksBeforeAdding = UserBookHistory.getInstance().getReadElectronicBooksByUser().size();
        UserBookHistoryHelper.addReadElectronicBookToUserHistory(user.getUsername(), electronicBook);
        int numberOfElectronicBooksAfterAdding = UserBookHistory.getInstance().getReadElectronicBooksByUser().size();
        assertFalse(numberOfElectronicBooksAfterAdding > numberOfElectronicBooksBeforeAdding);
    }

    @Test
    void shouldAddLoanedBookWhenGivenUsername() {
        LoanedBook loanedBook = new LoanedBook();
        User user = new User();
        user.setUsername("Jose");
        int numberOfLoanedBooksBeforeAdding = UserBookHistory.getInstance().getEveryLoanedBookByUser().size();
        UserBookHistoryHelper.addLoanedBookToUserHistory(user.getUsername(), loanedBook);
        int numberOfLoanedBooksAfterAdding = UserBookHistory.getInstance().getEveryLoanedBookByUser().size();
        assertTrue(numberOfLoanedBooksAfterAdding > numberOfLoanedBooksBeforeAdding);
    }

    @Test
    void shouldNotAddLoanedBookWhenNotGivenUsername() {
        LoanedBook loanedBook = new LoanedBook();
        User user = new User();
        int numberOfLoanedBooksBeforeAdding = UserBookHistory.getInstance().getEveryLoanedBookByUser().size();
        UserBookHistoryHelper.addLoanedBookToUserHistory(user.getUsername(), loanedBook);
        int numberOfLoanedBooksAfterAdding = UserBookHistory.getInstance().getEveryLoanedBookByUser().size();
        assertFalse(numberOfLoanedBooksAfterAdding > numberOfLoanedBooksBeforeAdding);
    }
}