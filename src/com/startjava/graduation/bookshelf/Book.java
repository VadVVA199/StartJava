package com.startjava.graduation.bookshelf;

public class Book {

    private final String author;
    private final String title;
    private final int yearPublication;
    private final int lenInfo;

    public Book(String author, String  title, int yearPublication) {
        this.author = author;
        this.title = title;
        this.yearPublication = yearPublication;
        this.lenInfo = toString().length();
    }

    public String getTitle() {
        return title;
    }

    public int getLenInfo() {
        return lenInfo;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + yearPublication;
    }
}
