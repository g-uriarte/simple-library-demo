package com.guriarte.librarydemo.errors;

public class LibraryBaseException extends Exception {

    public LibraryBaseException() {
    }

    public LibraryBaseException(String message) {
        super(message);
    }

    public LibraryBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryBaseException(Throwable cause) {
        super(cause);
    }

    public LibraryBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
