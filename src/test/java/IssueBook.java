
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        Date start = new Date(2022, 10, 20);
        Date end = new Date(2025, 10, 20);
        card = new LibraryCard(student, start, end, 8793952);
    }

    @AfterEach
    private void after(){
        student = null;
        book = null;
        card = null;
    }
}
