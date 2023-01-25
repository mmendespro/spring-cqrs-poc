package net.local.poc.springcqrs.adapters.commands.createbook;

import java.util.UUID;

import org.springframework.stereotype.Service;

import net.local.poc.springcqrs.application.domain.Book;
import net.local.poc.springcqrs.application.exceptions.BookAlreadyExistException;
import net.local.poc.springcqrs.application.ports.generators.IdGenerator;
import net.local.poc.springcqrs.application.ports.persistence.LoadBookPort;
import net.local.poc.springcqrs.application.ports.persistence.SaveBookPort;
import net.local.poc.springcqrs.infra.cqrs.Handler;

@Service
public class CreateBookHandler implements Handler<CreateBookCommand>{

    private final IdGenerator generator;
    private final LoadBookPort loadPort;
    private final SaveBookPort savePort;

    public CreateBookHandler(IdGenerator generator, LoadBookPort loadPort, SaveBookPort savePort) {
        this.generator = generator;
        this.loadPort = loadPort;
        this.savePort = savePort;
    }
    
    public void handle(CreateBookCommand command) {
        loadPort.findByTitle(command.getTitle()).ifPresent(book -> { throw new BookAlreadyExistException(); });
        savePort.save(new Book(UUID.fromString(generator.generate()), command.getTitle(), command.getAuthor()));
    }
}
