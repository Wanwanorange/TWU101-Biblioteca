import org.junit.Assert;
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
    private Printer printer;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        printstream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        printer = mock(Printer.class);
    }



    @Test
    public void shouldPrintListOfBooksWhenThereAreBooks() {
        books.add(new Book("Java", "Wanchen", 2020));
        books.add(new Book("Python", "Andy", 2021));
        books.add(new Book("Hunger Games", "Phoebe", 2022));

        biblioteca = new Biblioteca(printer, bufferedReader, books);

        biblioteca.listBooks();

        verify(printer).printArray(books);
    }

    @Test
    public void shouldNotifyUserWhenThereAreNoBooks() {
        biblioteca = new Biblioteca(printer, bufferedReader, books);

        biblioteca.listBooks();

        Mockito.verify(printer).printString("There are no books in the library.");
    }

    @Test
    public void shouldHaveMenuDisplayListBookOption() {
        biblioteca = new Biblioteca(printer, bufferedReader, books);
        biblioteca.displayMenu();
        verify(printer).printString("0. Quit\n1. List Books");
    }


    @Test
    public void shouldListBooksWhenOptionIs1() {
        //books.add(new Book("Java", "Wanchen", 2020));
        //books.add(new Book("Python", "Andy", 2021));
        books.add(new Book("Hunger Games", "Phoebe", 2022));
        biblioteca = new Biblioteca(printer, bufferedReader, books);
        try {
            Mockito.when(bufferedReader.readLine()).thenReturn("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        biblioteca.readUserMenuChoice();
        verify(printer).printString("You've selected List Books");
        verify(printer).printArray(books);
    }

    @Test
    public void shouldShowInvalidOptionMessage() {
        biblioteca = new Biblioteca(printer, bufferedReader, books);
        try {
            Mockito.when(bufferedReader.readLine()).thenReturn("squirrel");
        } catch (IOException e) {
            e.printStackTrace();
        }
        biblioteca.start();
        verify(printer).printString("That is an invalid menu option!\nPlease enter the number next to the option you want.");

    }

    @Test
    public void shouldShowGoodbyeMessageWhenUserSelectsQuit(){
        biblioteca = new Biblioteca(printer, bufferedReader, books);
        try {
            Mockito.when(bufferedReader.readLine()).thenReturn("0");
        } catch (IOException e) {
            e.printStackTrace();
        }
        biblioteca.readUserMenuChoice();
        verify(printer).printString("Goodbye! Thank you for visiting la Biblioteca!");

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