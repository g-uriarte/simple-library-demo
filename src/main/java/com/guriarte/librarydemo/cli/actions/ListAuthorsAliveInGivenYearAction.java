package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.errors.LibraryBaseException;

public class ListAuthorsAliveInGivenYearAction implements Action {

    public static final int OPTION = 5;

    @Override
    public int option() {
        return OPTION;
    }

    @Override
    public String description() {
        return "List books by language";
    }

    @Override
    public void perform() throws LibraryBaseException {

    }
}
