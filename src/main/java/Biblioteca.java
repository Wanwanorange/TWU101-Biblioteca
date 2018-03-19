import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Biblioteca {

    private Printer printer;
    private ArrayList<Book> books;
    private Menu menu;
    private BufferedReader bufferedReader;

    public Biblioteca(Printer printer, BufferedReader bufferedReader, ArrayList<Book> books, Menu menu) {
        this.books = books;
        this.menu = menu;
        this.printer = printer;
        this.bufferedReader = bufferedReader ;
    }

    public void start() {
        printer.printString("Welcome! Choose a menu option.");
        loopMenu();
    }

    public void loopMenu() {
        Boolean quit = false;
        while (quit==false) {
            displayMenu();
            quit = readUserMenuChoice();
        }
    }

    public void listBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();

        if (books.isEmpty()) {
            printer.printString("There are no books in the library.");
        }

        for (Book book:books) {
            if (book.available()) {
                availableBooks.add(book);
            }
        }
        printer.printArray(availableBooks);
    }

    public boolean readUserMenuChoice() {
        String choice = menu.readLine();
        if (choice.equals("1")) {
            printer.printString("You've selected List Books");
            listBooks();
        } else if (choice.equals("2")) {
            printer.printString("Please enter the title of the book you want to checkout: ");
            String title = "";
            try {
                title = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Book checkoutItem = findBookByTitle(title);
            checkoutItem.checkout();
        } else if (choice.equals("0")) {
            printer.printString("Goodbye! Thank you for visiting la Biblioteca!");
            return true;
        } else {
            printer.printString("That is an invalid menu option!\nPlease enter the number next to the option you want.");
        }
        return false;
    }

    private Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayMenu() {
        printer.printString(menu.returnOptions());
    }
}
