package net.local.poc.springcqrs.infra.cqrs;

public interface Handler<T extends Command> {
    void handle(T command);
}
