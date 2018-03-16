import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private ArrayList<Book> books;

    public Biblioteca(PrintStream printStream, BufferedReader bufferedReader, ArrayList<Book> books) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.books = books;
    }

    public void start() throws IOException {
        printStream.println("Welcome! Choose a menu option.");
        displayMenu();
        //listBooks();
    }

    public void listBooks() {

        if (books.isEmpty()) {
            printStream.println("There are no books in the library.");
        }

        for (Book book: books) {
            printStream.println(book.toString());
        }
    }

    public void displayMenu() throws IOException {
        printStream.println("1. List Books");
        String menuChoice = "0";
        try {
            menuChoice = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printStream.println(menuChoice);
        listBooks();

    }
}
