import book.Book;
import book.BookFactory;
import book.SearchByTitle;
import lib.*;
import user.UserSubscriber;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Library library = Library.getInstance();

        library.addObserver(new UserSubscriber("Alice"));
        library.addObserver(new UserSubscriber("Bob"));

        Book b1 = BookFactory.createBook("PAPER", "Design Patterns", "GoF", "Software");
        Book b2 = BookFactory.createBook("EBOOK", "Clean Code", "Robert Martin", "Programming");

        library.addBook(b1);
        library.addBook(b2);

        System.out.println("Search by title:");
        List<Book> results = library.searchBook(new SearchByTitle(), "Clean");

        results.forEach(Book::display);

        BorrowService borrow = new BasicBorrow();
        borrow = new ExtendedBorrowDecorator(borrow);
        borrow = new SpecialEditionDecorator(borrow);

        borrow.borrow(b1);
    }
}