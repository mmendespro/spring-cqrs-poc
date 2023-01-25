package net.local.poc.springcqrs.application.ports.persistence;

import java.util.List;
import java.util.Optional;

import net.local.poc.springcqrs.application.domain.Book;

public interface LoadBookPort {
    public List<Book> findAll();
    public Optional<Book> findById(String bookId);
    public Optional<Book> findByTitle(String title);
}
