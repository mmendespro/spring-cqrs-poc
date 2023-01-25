package net.local.poc.springcqrs.adapters.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import net.local.poc.springcqrs.application.domain.Book;
import net.local.poc.springcqrs.application.ports.persistence.DeleteBookPort;
import net.local.poc.springcqrs.application.ports.persistence.LoadBookPort;
import net.local.poc.springcqrs.application.ports.persistence.SaveBookPort;

@Repository
public class BookRepository implements LoadBookPort, SaveBookPort, DeleteBookPort {

    private Map<UUID, Book> inMemoryDB = new HashMap<>();

    @Override
    public void delete(Book book) {
        inMemoryDB.remove(book.getBookId());
    }

    @Override
    public void save(Book book) {
        inMemoryDB.putIfAbsent(book.getBookId(), book);
    }

    @Override
    public List<Book> findAll() {
        return inMemoryDB.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(String bookId) {
        return Optional.of(inMemoryDB.get(UUID.fromString(bookId)));
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return inMemoryDB.values().stream().filter(b -> title.equalsIgnoreCase(b.getTitle())).findFirst();
    }    
}
