package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    public static final int NUMBER_SHELVES = 10;
    private int countBooks;
    private final Book[] books = new Book[NUMBER_SHELVES];
    private int shelfLength;

    public boolean add(Book book) {
        if (countBooks < NUMBER_SHELVES) {
            books[countBooks] = book;
            if (book.getLenInfo() > shelfLength) {
                shelfLength = book.getLenInfo();
            }
            countBooks++;
            return true;
        }
        return false;
    }

    public Book find(String title) {
        for (int i = 0; i < countBooks; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
      }

    public boolean delete(String title) {
        for (int i = 0; i < countBooks; i++) {
            if (books[i].getTitle().equals(title)) {
                int lengthBookDelete = books[i].getLenInfo();
                System.arraycopy(books,i + 1, books, i, countBooks - (i + 1));
                books[countBooks - 1] = null;
                countBooks--;
                if (lengthBookDelete == shelfLength) {
                    shelfLength = calculateShelfLength();
                }
                return true;
            }
        }
        return false;
    }

    public Book[] getAll() {
        return Arrays.copyOf(books, countBooks);
    }

    public int getCountBooks() {
        return countBooks;
    }

    public int getAmountFreeSpace() {
        return NUMBER_SHELVES - countBooks;
    }

    public int getShelfLength() {
        return shelfLength;
    }

    public void clearShelves() {
        Arrays.fill(books, 0, countBooks, null);
        countBooks = 0;
        System.out.println("Очистили полки от книг");
    }

    public int calculateShelfLength() {
        int maxBookLength = 0;
        for (Book book : getAll()) {
            if (book.getLenInfo() == shelfLength) {
                return shelfLength;
            } else {
                maxBookLength = Math.max(book.getLenInfo(), maxBookLength);
            }
        }
        return maxBookLength;
    }
}
