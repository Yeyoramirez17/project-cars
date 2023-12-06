package com.project.cars.exception;

public class CustomerNotExistException extends RuntimeException {

    private static final String message = "Customer not found";

    public CustomerNotExistException(String message) {
        super(message);
    }

    public CustomerNotExistException() {
        super( message );
    }

}
