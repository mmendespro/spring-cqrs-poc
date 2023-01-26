package net.local.poc.springcqrs.adapters.commands.deletebook;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import net.local.poc.springcqrs.infra.cqrs.Command;
import net.local.poc.springcqrs.infra.validation.SelfValidating;

public class DeleteBookCommand extends SelfValidating<DeleteBookCommand> implements Command {
    
    @NotNull
    @Pattern(regexp = UUID_FORMAT, message = INVALID_UUID)
    private final String bookId;

    public DeleteBookCommand(String bookId) {
        this.bookId = bookId;
        validateSelf(this);
    }

    public UUID getBookId() {
        return UUID.fromString(bookId);
    }
}
