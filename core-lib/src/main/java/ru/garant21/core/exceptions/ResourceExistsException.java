package ru.garant21.core.exceptions;

public class ResourceExistsException extends RuntimeException {

    public ResourceExistsException(String message) {
        super(message);
    }

}