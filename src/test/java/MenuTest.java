import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

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
        assertEquals("1. List Books", menuOptions);
    }

    @Test
    public void shouldReadUserInput() {
        try {
            Mockito.when(bufferedReader.readLine()).thenReturn("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("You've selected List Books", menu.readUserMenuChoice());

    }


}