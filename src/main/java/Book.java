public class Book {

    private String title;
    private String author;
    private int yearPublished;
    private boolean checkedOut;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        checkedOut = false;
    }

    public String toString() {
        return title + "\t|\t" + author + "\t|\t" + yearPublished;
    }

    public void checkout() {
        this.checkedOut = true ;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean available() {
        return !this.checkedOut;
    }
}
