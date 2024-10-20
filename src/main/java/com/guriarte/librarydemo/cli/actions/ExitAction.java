package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.errors.LibraryBaseException;

public class ExitAction implements Action {

    public static final int OPTION = 6;


    @Override
    public int option() {
        return OPTION;
    }

    @Override
    public String description() {
        return "Exit";
    }

    @Override
    public void perform() throws LibraryBaseException {
        System.out.println("Bye!");
    }
}
