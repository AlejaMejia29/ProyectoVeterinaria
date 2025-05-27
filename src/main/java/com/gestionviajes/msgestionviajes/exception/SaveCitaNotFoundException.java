package com.gestionviajes.msgestionviajes.exception;

public class SaveCitaNotFoundException extends RuntimeException {
    public SaveCitaNotFoundException(String message) {
        super(message);
    }

    public SaveCitaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
