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

    public void printArray(ArrayList<Book> books) {
        for (Book book : books) {
            printStream.println(book.toString());
        }
    }
}
