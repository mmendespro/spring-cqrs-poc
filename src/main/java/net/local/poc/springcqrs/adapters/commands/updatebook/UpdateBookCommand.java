package net.local.poc.springcqrs.adapters.commands.updatebook;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import net.local.poc.springcqrs.infra.cqrs.Command;
import net.local.poc.springcqrs.infra.validation.SelfValidating;

public class UpdateBookCommand extends SelfValidating<UpdateBookCommand> implements Command {
    
    @NotNull
    @Pattern(regexp = UUID_FORMAT, message = INVALID_UUID)
    private final String bookId;

    @NotBlank
    @Size(min = 1, max = 100)
    private final String title;

    @NotBlank
    @Size(min = 1, max = 100)
    private final String author;

    public UpdateBookCommand(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        validateSelf();
    }

    public UUID getBookId() {
        return UUID.fromString(bookId);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    
}
