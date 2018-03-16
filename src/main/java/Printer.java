import java.io.PrintStream;
import java.util.ArrayList;

public class Printer {
    private PrintStream printStream;

    public Printer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printString(String string) {
        printStream.println(string);
    }

    public void printArray(ArrayList<String> books) {
        for (String book : books) {
            printStream.println(book);
        }
    }
}
