import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    private PrintStream printstream;
    private BufferedReader bufferedReader;
    private ArrayList<Book> books;

    @Before
    public void setUp() {
        books = new ArrayList<>();

        printstream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);

        try {
            Mockito.when(bufferedReader.readLine()).thenReturn("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void shouldPrintWelcomeMessage() {
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
    public void shouldHaveMenuDisplayListBookOption() {
        biblioteca = new Biblioteca(printstream, bufferedReader, books);
        biblioteca.displayMenu();
        verify(printstream).println("1. List Books");
    }

    @Test
    public void shouldReadUserInputInStart() {
        biblioteca = new Biblioteca(printstream, bufferedReader, books);
        biblioteca.start();
        verify(printstream).println("Welcome! Choose a menu option.");
        verify(printstream).println("1. List Books");
        verify(printstream).println("You've selected List Books");
    }

//    @Test
//    public void shouldPromptInputWhenCurrentOptionIsInvalid() {
//        Biblioteca mockBiblioteca = mock(Biblioteca.class);
//        try {
//            Mockito.when(bufferedReader.readLine()).thenReturn("squirrel");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        verify(mockBiblioteca, times(1)).runMenu();
//    }
//



}