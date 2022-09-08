package com.rest.exseption_handling;

public class NoSuchEmployeeException extends RuntimeException {
    public NoSuchEmployeeException (String message) {
        super(message);
    }
}
