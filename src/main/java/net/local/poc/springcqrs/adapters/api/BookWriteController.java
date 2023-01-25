package net.local.poc.springcqrs.adapters.api;

import java.net.URISyntaxException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.springcqrs.adapters.api.dto.BookRequest;
import net.local.poc.springcqrs.adapters.commands.createbook.CreateBookCommand;
import net.local.poc.springcqrs.adapters.commands.deletebook.DeleteBookCommand;
import net.local.poc.springcqrs.adapters.commands.updatebook.UpdateBookCommand;
import net.local.poc.springcqrs.infra.cqrs.ServiceBus;

@RestController
@RequestMapping("v1/books")
public class BookWriteController {
    
    private ServiceBus serviceBus;

    public BookWriteController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody BookRequest bookRequest) throws URISyntaxException {
        serviceBus.execute(new CreateBookCommand(bookRequest.getTitle(), bookRequest.getAuthor()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/{bookId}")
    public ResponseEntity<String> update(@Valid @NotNull @PathVariable(name = "bookId") String bookId, @RequestBody BookRequest bookRequest) {
        serviceBus.execute(new UpdateBookCommand(bookId, bookRequest.getTitle(), bookRequest.getAuthor()));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{bookId}")
    public ResponseEntity<String> delete(@Valid @NotNull @PathVariable(name = "bookId") String bookId) {
        serviceBus.execute(new DeleteBookCommand(bookId));
        return ResponseEntity.noContent().build();
    }
}
