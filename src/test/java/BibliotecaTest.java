import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    private PrintStream printstream;
    ArrayList<String> books;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        books.add("Java");
        books.add("Python");
        books.add("Hunger Games");
        printstream = mock(PrintStream.class);
        biblioteca = new Biblioteca(printstream, books);
    }


    @Test
    public void shouldPrintWelcomeMessage() {
        biblioteca.start();
        Mockito.verify(printstream).println("Welcome");
    }

    @Test
    public void shouldPrintListOfBooks() {
        biblioteca.listBooks();

        Mockito.verify(printstream).println("Java");
        Mockito.verify(printstream).println("Python");
        Mockito.verify(printstream).println("Hunger Games");
    }


}