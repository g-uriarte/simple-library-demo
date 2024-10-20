package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.errors.LibraryBaseException;

public class ListBooksByLanguageActions implements Action {

    public static final int OPTION = 4;

    @Override
    public int option() {
        return OPTION;
    }

    @Override
    public String description() {
        return "List authors alive in a given year";
    }

    @Override
    public void perform() throws LibraryBaseException {

    }
}
