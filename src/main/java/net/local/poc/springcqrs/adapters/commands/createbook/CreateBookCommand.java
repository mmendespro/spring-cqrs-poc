package net.local.poc.springcqrs.adapters.commands.createbook;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import net.local.poc.springcqrs.infra.cqrs.Command;
import net.local.poc.springcqrs.infra.validation.SelfValidating;

public class CreateBookCommand extends SelfValidating<CreateBookCommand> implements Command {
    
    @NotBlank
    @Size(min = 1, max = 100)
    private final String title;

    @NotBlank
    @Size(min = 1, max = 100)
    private final String author;

    public CreateBookCommand(String title, String author) {
        this.title = title;
        this.author = author;
        validateSelf();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    
}
