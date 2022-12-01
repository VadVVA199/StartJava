package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    public static final int NUMBER_SHELVES = 10;
    private int countBooks;
    private final Book[] books = new Book[NUMBER_SHELVES];

    public boolean addBook(Book book) {
        if (countBooks < NUMBER_SHELVES) {
            books[countBooks] = book;
            countBooks++;
            return true;
        }
        return false;
    }

    public <T> T findBook(String title) {
        for (int i = 0; i < countBooks; i++) {
            if (books[i].getTitle().equals(title)) {
                return (T) books[i];
            }
        }
        Integer number = -1;
        return (T) number;
    }

    public void delete(String title) {
        for (int i = 0; i < countBooks; i++) {
            if (books[i].getTitle().equals(title)) {
                System.arraycopy(books,i + 1, books, i, books.length - i - 1);
                Arrays.fill(books, books.length - 1, books.length, null);
                countBooks--;
           }
       }
    }

    public Book[] getAllBooks() {
        return Arrays.copyOf(books, countBooks);
    }

    public int getCountBooks() {
        return countBooks;
    }

    public int getAmountFreeSpace() {
        return NUMBER_SHELVES - countBooks;
    }

    public void clearShelf() {
        Arrays.fill(books, 0, countBooks - 1, null);
        countBooks = 0;
        System.out.println("Очистили полки от книг");
    }
}
