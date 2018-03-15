import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaRunner {

    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();
        books.add("Cat in the Hat");
        books.add("Headfirst Java");
        books.add("SQL the hard way");

        PrintStream printStream = new PrintStream(System.out);
        Biblioteca biblioteca = new Biblioteca(printStream, books);
        biblioteca.start();

    }
}
