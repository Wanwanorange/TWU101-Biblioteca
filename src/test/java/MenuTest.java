import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MenuTest {
    private Menu menu;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        menu = new Menu(bufferedReader);
    }

    @Test
    public void shouldDisplayMenuOptions() {

        String menuOptions = menu.returnOptions();
        assertEquals("0. Quit\n1. List Books", menuOptions);
    }








}