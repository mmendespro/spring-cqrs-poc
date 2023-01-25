package net.local.poc.springcqrs.adapters.queries.findall;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.local.poc.springcqrs.adapters.api.dto.BookResponse;
import net.local.poc.springcqrs.application.domain.Book;
import net.local.poc.springcqrs.application.ports.persistence.LoadBookPort;
import net.local.poc.springcqrs.infra.cqrs.Resolver;

@Service
public class FindAllBookResolver implements Resolver<FindAllBookQuery> {
    
    private final LoadBookPort loadPort;

    public FindAllBookResolver(LoadBookPort loadPort) {
        this.loadPort = loadPort;
    }

    @Override
    public void resolve(FindAllBookQuery query) {
        List<BookResponse> result = loadPort.findAll()
                                            .stream()
                                            .map(this::fromBookEntity)
                                            .collect(Collectors.toList());
        query.setResult(result);
    }

    private BookResponse fromBookEntity(Book book) {
        return new BookResponse(book.getBookId().toString(), book.getTitle(), book.getAuthor());
    }
}
