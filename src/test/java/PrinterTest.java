import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrinterTest {

    private PrintStream printStream;
    private Printer printer;

    @Before
    public void setUp() throws IOException{
        printStream = mock(PrintStream.class);
        printer = new Printer(printStream);
    }

    @Test
    public void shouldPrintCorrectString() {
        String string = "myString";
        printer.printString(string);
        verify(printStream).println(string);

    }

    @Test
    public void shouldPrintArrayList() {
        ArrayList<Book> books = new ArrayList<>();


        Book b1 = new Book("A Wrinkle In Time", "Madeleine L'engle", 1962);
        Book b2 = new Book("The BFG", "Roald Dahl", 1982);
        books.add(b1);
        books.add(b2);

        printer.printArray(books);
        verify(printStream).println(b1.toString());
        verify(printStream).println(b2.toString());

    }
}