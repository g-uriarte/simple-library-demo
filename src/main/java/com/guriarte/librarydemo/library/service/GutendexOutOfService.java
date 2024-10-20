package com.guriarte.librarydemo.library.service;

import com.guriarte.librarydemo.errors.LibraryBaseException;

public class GutendexOutOfService extends LibraryBaseException {
    public GutendexOutOfService() {
        super("Gutendex is out of service. Sorry!");
    }
}
