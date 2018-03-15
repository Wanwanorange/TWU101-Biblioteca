import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {

    private PrintStream printStream;
    private ArrayList<Book> books;

    public Biblioteca(PrintStream printStream, ArrayList<Book> books) {
        this.printStream = printStream;
        this.books = books;
    }

    public void start() {
        printStream.println("Welcome");
        listBooks();
    }

    public void listBooks() {

        if (books.isEmpty()) {
            printStream.println("There are no books in the library.");
        }

        for (Book book: books) {
            printStream.println(book.toString());
        }
    }
}
