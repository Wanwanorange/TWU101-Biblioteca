import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    private PrintStream printstream;
    ArrayList<Book> books;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        books.add(new Book("Java", "Wanchen", 2020));
        books.add(new Book("Python", "Andy", 2021));
        books.add(new Book("Hunger Games", "Phoebe", 2022));
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

        Mockito.verify(printstream).println("Java\t|\tWanchen\t|\t2020");
        Mockito.verify(printstream).println("Python\t|\tAndy\t|\t2021");
        Mockito.verify(printstream).println("Hunger Games\t|\tPhoebe\t|\t2022");
    }


}