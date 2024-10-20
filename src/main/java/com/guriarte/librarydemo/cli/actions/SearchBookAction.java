package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.errors.LibraryBaseException;

public class SearchBookAction implements Action {

    public static final int OPTION = 1;

    @Override
    public int option() {
        return OPTION;
    }

    @Override
    public String description() {
        return "Search book by title";
    }

    @Override
    public void perform() throws LibraryBaseException {

    }
}
