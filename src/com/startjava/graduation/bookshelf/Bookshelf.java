package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    public final int NUMBER_SHELVES = 10;
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

    public Book findBook(String titleBook) {
        for (int i = 0; i < countBooks; i++) {
            if (books[i].getTitle().equals(titleBook)) {
                return books[i];
            }
        }
        throw new IllegalArgumentException("Данная книга по названию " + titleBook + " не найдена");
    }

    public void delete(String titleBook) {
        for (int i = 0; i < countBooks; i++) {
            if (books[i].getTitle().equals(titleBook)) {
                Book[] arrayCopyBooks = new Book[NUMBER_SHELVES];
                System.arraycopy(books,0, arrayCopyBooks, 0, i);
                System.arraycopy(books,i + 1, arrayCopyBooks, i, books.length - i - 1);
                Arrays.fill(books, null);
                System.arraycopy(arrayCopyBooks, 0, books, 0, books.length);
                countBooks--;
           }
       }
    }

    public Book[] getNumberBooks() {
        return Arrays.copyOf(books, countBooks);
    }

    public int getCountBooks() {
        return countBooks;
    }

    public int getAmountFreeSpace() {
        return NUMBER_SHELVES - countBooks;
    }

    public void clearShelf() {
        Arrays.fill(books, null);
        countBooks = 0;
        System.out.println("Очистили полки от книг");
    }
}
