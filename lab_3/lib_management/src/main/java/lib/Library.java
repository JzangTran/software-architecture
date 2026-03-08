package lib;

import book.Book;
import book.SearchStrategy;
import user.Observer;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private static Library instance;

    private List<Book> books = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private Library() {}

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers("New book added: " + book.getTitle());
    }

    public List<Book> searchBook(SearchStrategy strategy, String keyword) {
        return strategy.search(books, keyword);
    }

    public List<Book> getBooks() {
        return books;
    }
}