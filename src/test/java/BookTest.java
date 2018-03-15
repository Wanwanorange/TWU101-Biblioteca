import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void setUp() {
        book = new Book("Harry Potter and the Philosopher's Stone", "JK Rowling", 1997);
    }

    @Test
    public void shouldReturnBookDetails() {
        assertEquals(book.toString(), "Harry Potter and the Philosopher's Stone\t|\tJK Rowling\t|\t1997");
    }

}