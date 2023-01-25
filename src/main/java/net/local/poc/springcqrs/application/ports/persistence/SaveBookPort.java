package net.local.poc.springcqrs.application.ports.persistence;

import net.local.poc.springcqrs.application.domain.Book;

public interface SaveBookPort {
    void save(Book book);
}
