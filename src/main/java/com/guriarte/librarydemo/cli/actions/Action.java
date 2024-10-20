package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.errors.LibraryBaseException;

public interface Action {

    int option();

    String description();

    void perform() throws LibraryBaseException;

}
