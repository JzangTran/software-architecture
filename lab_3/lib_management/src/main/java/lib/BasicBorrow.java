package lib;

import book.Book;

public class BasicBorrow implements BorrowService {

    @Override
    public void borrow(Book book) {
        System.out.println("Borrowing book: " + book.getTitle());
    }
}
