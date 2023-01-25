package net.local.poc.springcqrs.adapters.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.springcqrs.adapters.api.dto.BookResponse;
import net.local.poc.springcqrs.adapters.queries.findall.FindAllBookQuery;
import net.local.poc.springcqrs.adapters.queries.findbyid.FindByIdQuery;
import net.local.poc.springcqrs.infra.cqrs.ServiceBus;

@RestController
@RequestMapping("v1/books")
public class BookReadController {

    private final ServiceBus serviceBus;

    public BookReadController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAllBooks() {
        var query = new FindAllBookQuery();
        serviceBus.execute(query);
        return ResponseEntity.ok(query.getResult());
    }

    @GetMapping(path = "/{bookId}")
    public ResponseEntity<BookResponse> findBook(@Valid @NotNull @PathVariable(name = "bookId") String bookId) {
        var query = new FindByIdQuery(bookId);
        serviceBus.execute(query);
        return ResponseEntity.ok(query.getResult());
    }
}
