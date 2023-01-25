package net.local.poc.springcqrs.adapters.queries.findbyid;

import net.local.poc.springcqrs.adapters.api.dto.BookResponse;
import net.local.poc.springcqrs.infra.cqrs.Query;

public class FindByIdQuery implements Query {
    
    private String bookId;
    private BookResponse result;

    public FindByIdQuery(String bookId) {
        this.bookId = bookId;
    }

    public BookResponse getResult() {
        return result;
    }

    public void setResult(BookResponse result) {
        this.result = result;
    }

    public String getBookId() {
        return bookId;
    }
}
