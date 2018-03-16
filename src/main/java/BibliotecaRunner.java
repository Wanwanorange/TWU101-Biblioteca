import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaRunner {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Book cat_in_the_hat = new Book("Cat in the Hat", "Dr. Suess", 1956);
        Book headfirst_java = new Book("Headfirst Java", "Someone", 1980);
        Book sql = new Book("SQL the hard way", "Someone Else", 2017);
        books.add(cat_in_the_hat);
        books.add(headfirst_java);
        books.add(sql);

        PrintStream printStream = new PrintStream(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Biblioteca biblioteca = new Biblioteca(printStream, bufferedReader, books);
        biblioteca.start();

    }
}
