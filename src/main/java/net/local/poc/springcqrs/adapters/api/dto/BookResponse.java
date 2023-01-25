package net.local.poc.springcqrs.adapters.api.dto;

public class BookResponse {
    
    private String bookId;
    private String title;
    private String author;

    public BookResponse(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
