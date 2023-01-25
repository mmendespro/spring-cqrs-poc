package net.local.poc.springcqrs.application.exceptions;

public class BookAlreadyExistException extends RuntimeException {

    public BookAlreadyExistException() {
        super("Book already exists.");
    }
    
}
