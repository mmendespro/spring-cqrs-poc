package net.local.poc.springcqrs.application.domain;

import java.util.UUID;

public class Book {

    private UUID bookId;
    private String title;
    private String author;

    public Book() {}

    public Book(UUID bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Book {bookId=%s, title=%s, author=%s}", bookId.toString(), title, author);
    }    
}
