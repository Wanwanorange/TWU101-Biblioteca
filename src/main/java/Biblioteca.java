import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {

    private PrintStream printStream;
    private Printer printer;
    private ArrayList<Book> books;
    private Menu menu;

    public Biblioteca(PrintStream printStream, BufferedReader bufferedReader, ArrayList<Book> books) {
        this.printStream = printStream;
        this.books = books;
        menu = new Menu(bufferedReader);
        printer = new Printer(printStream);
    }

    public void start() {
        printStream.println("Welcome! Choose a menu option.");
        displayMenu();
        runMenu();
    }

    public void listBooks() {

        if (books.isEmpty()) {
            printStream.println("There are no books in the library.");
        }

        for (Book book: books) {
            printStream.println(book.toString());
        }
    }

    public void displayMenu() {
        printer.printString(menu.returnOptions());
    }


    public void runMenu() {
        printer.printString(menu.readUserMenuChoice());
    }
}
