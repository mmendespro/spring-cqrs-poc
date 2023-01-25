package net.local.poc.springcqrs.adapters.queries.findall;

import java.util.List;

import net.local.poc.springcqrs.adapters.api.dto.BookResponse;
import net.local.poc.springcqrs.infra.cqrs.Query;

public class FindAllBookQuery implements Query {
    
    private List<BookResponse> result;

    public List<BookResponse> getResult() {
        return result;
    }
    
    public void setResult(List<BookResponse> result) {
        this.result = result;
    }
}
