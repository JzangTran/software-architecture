package lib;

import book.Book;

public class SpecialEditionDecorator extends BorrowDecorator {

    public SpecialEditionDecorator(BorrowService borrowService) {
        super(borrowService);
    }

    @Override
    public void borrow(Book book) {
        super.borrow(book);
        System.out.println("Special edition requested for: " + book.getTitle());
    }
}
