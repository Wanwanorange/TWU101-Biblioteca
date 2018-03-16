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

        printstream = mock(PrintStream.class);

    }


    @Test
    public void shouldPrintWelcomeMessage() {
        biblioteca = new Biblioteca(printstream, books);

        biblioteca.start();
        Mockito.verify(printstream).println("Welcome");
    }

    @Test
    public void shouldPrintListOfBooksWhenThereAreBooks() {
        books.add(new Book("Java", "Wanchen", 2020));
        books.add(new Book("Python", "Andy", 2021));
        books.add(new Book("Hunger Games", "Phoebe", 2022));

        biblioteca = new Biblioteca(printstream, books);

        biblioteca.listBooks();

        Mockito.verify(printstream).println("Java\t|\tWanchen\t|\t2020");
        Mockito.verify(printstream).println("Python\t|\tAndy\t|\t2021");
        Mockito.verify(printstream).println("Hunger Games\t|\tPhoebe\t|\t2022");
    }

    @Test
    public void shouldNotifyUserWhenThereAreNoBooks() {
        biblioteca = new Biblioteca(printstream, books);

        biblioteca.listBooks();

        Mockito.verify(printstream).println("There are no books in the library.");
    }

    @Test
    public void shouldHaveMenuDisplayListBookOption() {
        biblioteca = new Biblioteca(printstream, books);
        biblioteca.displayMenu();
        Mockito.verify(printstream).println("1. List Books");
    }






}