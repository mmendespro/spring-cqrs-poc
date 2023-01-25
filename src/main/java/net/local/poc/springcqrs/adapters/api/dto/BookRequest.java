package net.local.poc.springcqrs.adapters.api.dto;

public class BookRequest {
    
    private String title;
    private String author;

    public BookRequest(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
