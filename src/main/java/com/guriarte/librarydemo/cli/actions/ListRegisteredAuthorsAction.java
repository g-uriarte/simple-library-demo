package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.errors.LibraryBaseException;

public class ListRegisteredAuthorsAction implements Action {

    public static final int OPTION = 3;

    @Override
    public int option() {
        return OPTION;
    }

    @Override
    public String description() {
        return "List registered authors";
    }

    @Override
    public void perform() throws LibraryBaseException {

    }
}
