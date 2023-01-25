package net.local.poc.springcqrs.adapters.queries.findbyid;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import net.local.poc.springcqrs.adapters.api.dto.BookResponse;
import net.local.poc.springcqrs.application.domain.Book;
import net.local.poc.springcqrs.application.ports.persistence.LoadBookPort;
import net.local.poc.springcqrs.infra.cqrs.Resolver;

@Service
public class FindByIdResolver implements Resolver<FindByIdQuery> {
    
    private final LoadBookPort loadPort;

    public FindByIdResolver(LoadBookPort loadPort) {
        this.loadPort = loadPort;
    }

    @Override
    public void resolve(FindByIdQuery query) {
        var book = loadPort.findById(query.getBookId()).orElseThrow(NoSuchElementException::new);
        query.setResult(fromBookEntity(book));
    }
    
    private BookResponse fromBookEntity(Book book) {
        return new BookResponse(book.getBookId().toString(), book.getTitle(), book.getAuthor());
    }

}
