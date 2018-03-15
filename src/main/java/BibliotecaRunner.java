import java.io.PrintStream;

public class BibliotecaRunner {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Biblioteca biblioteca = new Biblioteca(printStream);
        biblioteca.start();
    }
}
