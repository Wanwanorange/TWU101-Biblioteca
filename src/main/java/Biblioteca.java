import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {

    private Printer printer;
    private ArrayList<Book> books;
    private Menu menu;

    public Biblioteca(Printer printer, BufferedReader bufferedReader, ArrayList<Book> books) {
        this.books = books;
        menu = new Menu(bufferedReader);
        this.printer = printer;
    }

    public void start() {
        printer.printString("Welcome! Choose a menu option.");
        displayMenu();
        readUserMenuChoice();
    }

    public void listBooks() {

        if (books.isEmpty()) {
            printer.printString("There are no books in the library.");
        }

        printer.printArray(books);
    }

    public void readUserMenuChoice() {
        String choice = menu.readLine();
        if (choice.equals("1")) {
            printer.printString("You've selected List Books");
            listBooks();
        } else if (choice.equals("0")) {
            printer.printString("Goodbye! Thank you for visiting la Biblioteca!");
        }
        else {
            printer.printString("That is an invalid menu option!\nPlease enter the number next to the option you want.");
        }

    }

    public void displayMenu() {
        printer.printString(menu.returnOptions());
    }


    //public void runMenu() {
     //   printer.printString(menu.readUserMenuChoice());
  //  }
}
