package book;

public class EBook extends Book {

    public EBook(String title, String author, String category) {
        super(title, author, category);
    }

    @Override
    public void display() {
        System.out.println("EBook: " + title);
    }
}
