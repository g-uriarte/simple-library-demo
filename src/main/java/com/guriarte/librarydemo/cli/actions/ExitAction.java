package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.cli.console.ConsolePrinter;

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
    public void perform() {
        ConsolePrinter.println("Bye!");
    }
}
