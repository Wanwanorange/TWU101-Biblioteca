import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

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

}