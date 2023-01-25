package net.local.poc.springcqrs.application.ports.persistence;

import net.local.poc.springcqrs.application.domain.Book;

public interface DeleteBookPort {
    void delete(Book book);
}
