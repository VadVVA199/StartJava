package com.startjava.graduation.bookshelf;

public class Book {

    private final String author;
    private final String title;
    private final int yearPublication;

    public Book(String author, String  title, int yearPublication) {
        this.author = author;
        this.title = title;
        this.yearPublication = yearPublication;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + yearPublication;
    }
}
