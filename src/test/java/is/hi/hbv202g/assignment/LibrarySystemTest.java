package is.hi.hbv202g.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class LibrarySystemTest {
    private LibrarySystem librarySystem;

    @BeforeEach
    void setup() {
        librarySystem = LibrarySystem.getInstance();
    }

    @Test
    void testAddAndFindBook() {
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("New Book", "New Author");
        assertNotNull(librarySystem.findBookByTitle("New Book"), "Book should be found");
    }

    @Test
    void testAddAndFindUser() {
        librarySystem.addStudentUser("New Student", true);
        assertNotNull(librarySystem.findUserByName("New Student"), "User should be found");
    }
}
