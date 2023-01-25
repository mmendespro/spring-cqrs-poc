package net.local.poc.springcqrs.adapters.commands.updatebook;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import net.local.poc.springcqrs.application.domain.Book;
import net.local.poc.springcqrs.application.ports.persistence.LoadBookPort;
import net.local.poc.springcqrs.application.ports.persistence.SaveBookPort;
import net.local.poc.springcqrs.infra.cqrs.Handler;

@Service
public class UpdateBookHandler implements Handler<UpdateBookCommand>{

    private final LoadBookPort loadPort;
    private final SaveBookPort savePort;

    public UpdateBookHandler(LoadBookPort loadPort, SaveBookPort savePort) {
        this.loadPort = loadPort;
        this.savePort = savePort;
    }
    
    public void handle(UpdateBookCommand command) {
        loadPort.findById(command.getBookId().toString()).orElseThrow(NoSuchElementException::new);
        savePort.save(new Book(command.getBookId(), command.getAuthor(), command.getTitle()));
    }
}
