package com.startjava.graduation.bookshelf;

public class Book {

    private final String author;
    private final String title;
    private final int yearPublication;
    private final int bookLength;

    public Book(String author, String  title, int yearPublication) {
        this.author = author;
        this.title = title;
        this.yearPublication = yearPublication;
        this.bookLength = (author + ", " + title + ", " + yearPublication).length();
    }

    public String getTitle() {
        return title;
    }

    public int getBookLength() {
        return bookLength;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + yearPublication;
    }
}
