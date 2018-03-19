import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {

    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public Menu(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
        printStream = new PrintStream(System.out);
    }

    public String returnOptions() {
        return "0. Quit\n1. List Books";
    }

    public String readLine() {
        String choice = null;
        try {
            choice = bufferedReader.readLine();
        } catch (IOException e) {
            printStream.println("That is an invalid menu option!\nPlease enter the number next to the option you want.");
        }
        return choice;
    }


}
