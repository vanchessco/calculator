package org.example.exception.visitor;


public class VisitorNotFoundException extends RuntimeException {

    public VisitorNotFoundException() {
        super();
    }

    public <T> VisitorNotFoundException(Class<T> cls, Long id) {
        super(cls.getSimpleName() + " with id: " + id + " does not exist!");

    }
}
