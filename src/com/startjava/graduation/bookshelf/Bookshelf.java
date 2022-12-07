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
            shelfLength = calculateShelfLength(book.getBookLength(), "add");
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
                int lengthBookDelete = books[i].getBookLength();
                System.arraycopy(books,i + 1, books, i, countBooks - (i + 1));
                books[countBooks - 1] = null;
                countBooks--;
                shelfLength = calculateShelfLength(lengthBookDelete, "delete");
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

    public int calculateShelfLength(int bookLength, String operation) {
        if (bookLength >= shelfLength) {
            return switch (operation) {
                case "add" -> bookLength;
                case "delete" -> {
                    int maxBookLength = 0;
                    for (Book book : getAll()) {
                        if (book.getBookLength() == shelfLength) {
                            maxBookLength =shelfLength;
                            break;
                        } else {
                            maxBookLength = Math.max(book.getBookLength(), maxBookLength);
                        }
                    }
                    yield maxBookLength;
                }
                default -> throw new IllegalArgumentException("Ошибка операции");
            };
        }
        return shelfLength;
    }
}
