package net.local.poc.springcqrs.adapters.commands.deletebook;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import net.local.poc.springcqrs.application.ports.persistence.DeleteBookPort;
import net.local.poc.springcqrs.application.ports.persistence.LoadBookPort;
import net.local.poc.springcqrs.infra.cqrs.Handler;

@Service
public class DeleteBookHandler implements Handler<DeleteBookCommand>{

    private final LoadBookPort loadPort;
    private final DeleteBookPort deletePort;

    public DeleteBookHandler(LoadBookPort loadPort, DeleteBookPort deletePort) {
        this.loadPort = loadPort;
        this.deletePort = deletePort;
    }
    
    public void handle(DeleteBookCommand command) {
        var book = loadPort.findById(command.getBookId().toString()).orElseThrow(NoSuchElementException::new);
        deletePort.delete(book);
    }
}
