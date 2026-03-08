package lib;

import book.Book;

public abstract class BorrowDecorator implements BorrowService {

    protected BorrowService borrowService;

    public BorrowDecorator(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @Override
    public void borrow(Book book) {
        borrowService.borrow(book);
    }
}