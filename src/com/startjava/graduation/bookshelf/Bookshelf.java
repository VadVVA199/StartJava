package com.startjava.graduation.bookshelf;

public class Bookshelf {

    public final int NUMBER_SHELVES = 10;
    private int numberBookOnShelves;
    private final Book[] arrayTenBooks = new Book[NUMBER_SHELVES];

    public boolean addBook(Book book) {
        for (int i = 0; i < arrayTenBooks.length; i++) {
            if (arrayTenBooks[i] == null) {
                arrayTenBooks[i] = book;
                numberBookOnShelves++;
                return true;
            }
        }
        return false;
    }

    public int findBook(String string) {
        for (int i = 0; i < arrayTenBooks.length; i++) {
            if (arrayTenBooks[i] != null && arrayTenBooks[i].getTitle().equals(string)) {
               return i;
            }
        }
        return -1;
    }

    public void delete(int index) {
        System.out.print("Книга " + arrayTenBooks[index] + " удалена");
        arrayTenBooks[index] = null;
        for (int i = 0; i < arrayTenBooks.length - 1; i++) {
            if (arrayTenBooks[i] == null) {
                for (int j = i; j < arrayTenBooks.length - 1; j++) {
                    if (arrayTenBooks[j + 1] != null) {
                        arrayTenBooks[i] = arrayTenBooks[j + 1];
                        arrayTenBooks[j + 1] = null;
                        break;
                    }
                }
            }
        }
        numberBookOnShelves--;
        System.out.println();
    }

    public Book[] getNumberBooks() {
        return arrayTenBooks;
    }

    public int getNumberBookOnShelves() {
        return numberBookOnShelves;
    }

    public int getAmountFreeSpace() {
        int amountFreeSpace = 0;
        for (Book book : arrayTenBooks) {
            if (book == null) {
                amountFreeSpace++;
            }
        }
        return amountFreeSpace;
    }

    public void clearShelf() {
        for (int i = 0; i < arrayTenBooks.length; i++) {
            if (arrayTenBooks[i] != null) {
                arrayTenBooks[i] = null;
            }
            numberBookOnShelves = 0;
        }
        System.out.println("Очистили полки от книг");
    }
}
