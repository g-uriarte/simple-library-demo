package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.errors.LibraryBaseException;

public class ListRegisteredBooksAction implements Action {

    public static final int OPTION = 2;

    @Override
    public int option() {
        return OPTION;
    }

    @Override
    public String description() {
        return "List registered books";
    }

    @Override
    public void perform() throws LibraryBaseException {

    }
}
