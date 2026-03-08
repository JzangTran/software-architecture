package book;

public class AudioBook extends Book {

    public AudioBook(String title, String author, String category) {
        super(title, author, category);
    }

    @Override
    public void display() {
        System.out.println("AudioBook: " + title);
    }
}
