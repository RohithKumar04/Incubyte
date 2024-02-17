package com.incubyte.application;

public class InvalidException extends RuntimeException {

    private String message;

    public InvalidException(String message) {
        super(message);
    }
}
