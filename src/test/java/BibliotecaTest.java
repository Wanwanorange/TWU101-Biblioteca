import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private BufferedReader bufferedReader;
    private Printer printer;
    private Menu menu;
    private ArrayList<Book> books;
    private Book javaBook;
    private Book pythonBook;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printer = mock(Printer.class);
        menu = new Menu(bufferedReader);

        books = new ArrayList<>();
        javaBook = new Book("Java", "Wanchen", 2020);
        pythonBook = new Book("Python", "Andy", 2021);
        books.add(javaBook);
        books.add(pythonBook);
        biblioteca = new Biblioteca(printer, bufferedReader, books, menu);
    }

    @Test
    public void shouldPrintListOfBooksWhenThereAreBooks() {
        biblioteca.listBooks();
        verify(printer).printArray(books);
    }

    @Test
    public void shouldNotifyUserWhenThereAreNoBooks() {
        biblioteca = new Biblioteca(printer, bufferedReader, new ArrayList<Book>(), menu);
        biblioteca.listBooks();
        Mockito.verify(printer).printString("There are no books in the library.");
    }

    @Test
    public void shouldHaveMenuDisplayListBookOption() {
        biblioteca.displayMenu();
        verify(printer).printString(menu.returnOptions());
    }

    @Test
    public void shouldListBooksWhenOptionIs1AndThereAreBooks() throws IOException {
        Mockito.when(bufferedReader.readLine()).thenReturn("1");

        biblioteca.readUserMenuChoice();
        verify(printer).printString("You've selected List Books");
        verify(printer).printArray(books);
    }

    @Test
    public void shouldShowInvalidOptionMessage() throws IOException {
        Mockito.when(bufferedReader.readLine()).thenReturn("squirrel");

        biblioteca.readUserMenuChoice();
        verify(printer).printString("That is an invalid menu option!\nPlease enter the number next to the option you want.");
    }

    @Test
    public void shouldShowGoodbyeMessageWhenUserSelectsQuit() throws IOException {
        Mockito.when(bufferedReader.readLine()).thenReturn("0");
        biblioteca.readUserMenuChoice();
        verify(printer).printString("Goodbye! Thank you for visiting la Biblioteca!");
    }

    @Test
    public void shouldLetUserMakeMultipleSelections() throws IOException {
        Mockito.when(bufferedReader.readLine()).thenReturn("1").thenReturn("0");
        biblioteca.start();
        verify(printer).printString("Welcome! Choose a menu option.");
        verify(printer, times(2)).printString(menu.returnOptions());
        verify(printer).printString("You've selected List Books");
        verify(printer).printArray(books);
        verify(printer).printString("Goodbye! Thank you for visiting la Biblioteca!");
    }

    @Test
    public void shouldPromptUserToEnterTitleAfterSelectisdfngCheckoutBooks() throws IOException {
        Mockito.when(bufferedReader.readLine()).thenReturn("2").thenReturn(javaBook.getTitle());
        biblioteca.readUserMenuChoice();
        verify(printer).printString("Please enter the title of the book you want to checkout: ");

        when(bufferedReader.readLine()).thenReturn("1");
        biblioteca.readUserMenuChoice();
        verify(printer).printString("You've selected List Books");

        ArrayList<Book> expectedAvailableBooks = new ArrayList<>();
        expectedAvailableBooks.add(pythonBook);
        verify(printer).printArray(expectedAvailableBooks);
    }

    @Test
    public void shouldPrintThankYouMessageAfterCheckout() throws IOException {
        Mockito.when(bufferedReader.readLine()).thenReturn("2").thenReturn(javaBook.getTitle());
        biblioteca.readUserMenuChoice();
        verify(printer).printString("Thank you! Enjoy the book.");
    }


}