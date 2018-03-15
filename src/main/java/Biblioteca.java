import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {

    private PrintStream printStream;
    private ArrayList<String> books;

    public Biblioteca(PrintStream printStream, ArrayList<String> books) {
        this.printStream = printStream;
        this.books = books;
    }

    public void start() {
        printStream.println("Welcome");
        listBooks();
    }

    public void listBooks() {
        for (String book: books) {
            printStream.println(book);
        }
    }

    public void listBooksWithAuthorAndYear() {

    }
}
