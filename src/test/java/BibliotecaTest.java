import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    private PrintStream printstream;

    @Before
    public void setUp() {
        printstream = mock(PrintStream.class);
        biblioteca = new Biblioteca(printstream);
    }


    @Test
    public void shouldPrintWelcomeMessage() {
        biblioteca.start();
        Mockito.verify(printstream).println("Welcome");
    }
}