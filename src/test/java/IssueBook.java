
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

/**
 *  Implement and test {Programme.addStudent } that respects the considtion given the assignment specification
 * NOTE: You are expected to verify that the constraints to borrow a new book from a library
 *
 * Each test criteria must be in an independent test method .
 *
 * Initialize the test object with "setting" method.
 */
public class IssueBook {
	Student student;
    Book book;
    LibraryCard card;

	@BeforeEach
    private void before(){
        student = new Student("Cam", 3952879);
        book = new Book(9782593, "Resources Of Tomorrow", 0);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 10, 20);
        Date start = calendar.getTime();
        calendar.set(2025, 10, 20);
        Date end = calendar.getTime();
        card = new LibraryCard(student, start, end, 8793952);
    }

    @AfterEach
    private void after(){
        student = null;
        book = null;
        card = null;
    }

    @Test //test under tthe default values as given in before(), this should return true
    public void True_standardValues() throws IllegalBookIssueException{
        boolean result = card.issueBook(book);
        assertTrue(result);
    }

    @Test //testing if the card has less than 4 books borrowed, this should return true
    public void True_3borrowed() throws IllegalBookIssueException{
        Book testBook1 = new Book(1, null, 0);
        card.issueBook(testBook1);
        Book testBook2 = new Book(2, null, 0);
        card.issueBook(testBook2);
        Book testBook3 = new Book(3, null, 0);
        card.issueBook(testBook3);

        boolean result = card.issueBook(book);
        assertTrue(result);
    }

    @Test //testing if the card has exactly 4 books borrowed, this should return true
    public void True_4borrowed() throws IllegalBookIssueException{
        Book testBook1 = new Book(1, null, 0);
        card.issueBook(testBook1);
        Book testBook2 = new Book(2, null, 0);
        card.issueBook(testBook2);
        Book testBook3 = new Book(3, null, 0);
        card.issueBook(testBook3);
        Book testBook4 = new Book(4, null, 0);
        card.issueBook(testBook4);

        boolean result = card.issueBook(book);
        assertTrue(result);
    }

    @Test //testing if the card has more than 4 books borrowed, this should return false
    public void False_5borrowed() throws IllegalBookIssueException{
        Book testBook1 = new Book(1, null, 0);
        card.issueBook(testBook1);
        Book testBook2 = new Book(2, null, 0);
        card.issueBook(testBook2);
        Book testBook3 = new Book(3, null, 0);
        card.issueBook(testBook3);
        Book testBook4 = new Book(4, null, 0);
        card.issueBook(testBook4);
        Book testBook5 = new Book(5, null, 0);
        card.issueBook(testBook5);

        boolean result = card.issueBook(book);
        assertFalse(result);
    }

    @Test //testing adding the same book into the card twice, this should throw IllegalBookIssueException
    public void TrowsIllegalBookIssueException_sameBookTwice() throws IllegalBookIssueException{
        card.issueBook(book);
         assertThrows(IllegalBookIssueException.class, () -> {
            card.issueBook(book);
        });
    }

    @Test //testing attempting to issue a book while there is a fine on the card, this should return false
    public void ReturnFalse_issueWithFine() throws IllegalBookIssueException {
        double fine = 15.00;
        card.setFine(fine);
        boolean result = card.issueBook(book);
        assertFalse(result);
    }
}
