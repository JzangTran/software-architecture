package lib;

import book.Book;

public class ExtendedBorrowDecorator extends BorrowDecorator {

    public ExtendedBorrowDecorator(BorrowService borrowService) {
        super(borrowService);
    }

    @Override
    public void borrow(Book book) {
        super.borrow(book);
        System.out.println("Extended borrow time for book: " + book.getTitle());
    }
}