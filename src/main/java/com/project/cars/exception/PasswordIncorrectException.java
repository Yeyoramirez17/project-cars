package com.project.cars.exception;

public class PasswordIncorrectException extends RuntimeException {

    private static final String message = "Password incorrect, please try again";

    public PasswordIncorrectException( String message ) {
        super( message );
    }

    public PasswordIncorrectException() {
        super( message );
    }

}
