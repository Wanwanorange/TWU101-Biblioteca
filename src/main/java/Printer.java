import java.io.PrintStream;

public class Printer {
    private PrintStream printStream;

    public Printer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printString(String string) {
        printStream.println(string);
    }
}
