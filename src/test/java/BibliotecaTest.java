import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    private PrintStream printstream;
    private BufferedReader bufferedReader;
    ArrayList<Book> books;

    @Before
    public void setUp() {
        books = new ArrayList<>();

        printstream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
    }


    @Test
    public void shouldPrintWelcomeMessage() throws IOException {
        biblioteca = new Biblioteca(printstream, bufferedReader, books);

        biblioteca.start();
        Mockito.verify(printstream).println("Welcome! Choose a menu option.");
    }

    @Test
    public void shouldPrintListOfBooksWhenThereAreBooks() {
        books.add(new Book("Java", "Wanchen", 2020));
        books.add(new Book("Python", "Andy", 2021));
        books.add(new Book("Hunger Games", "Phoebe", 2022));

        biblioteca = new Biblioteca(printstream, bufferedReader, books);

        biblioteca.listBooks();

        Mockito.verify(printstream).println("Java\t|\tWanchen\t|\t2020");
        Mockito.verify(printstream).println("Python\t|\tAndy\t|\t2021");
        Mockito.verify(printstream).println("Hunger Games\t|\tPhoebe\t|\t2022");
    }

    @Test
    public void shouldNotifyUserWhenThereAreNoBooks() {
        biblioteca = new Biblioteca(printstream, bufferedReader, books);

        biblioteca.listBooks();

        Mockito.verify(printstream).println("There are no books in the library.");
    }

    @Test
    public void shouldHaveMenuDisplayListBookOption() throws IOException {
        biblioteca = new Biblioteca(printstream, bufferedReader, books);
        biblioteca.displayMenu();
        Mockito.verify(printstream).println("1. List Books");
    }

    @Test
    public void shouldRespondToUserInput() throws IOException {
        books.add(new Book("Java", "Wanchen", 2020));

        biblioteca = new Biblioteca(printstream, bufferedReader, books);
        biblioteca.displayMenu();
        Mockito.when(bufferedReader.readLine()).thenReturn("1");
        Mockito.verify(printstream).println("Java\t|\tWanchen\t|\t2020");
    }




}