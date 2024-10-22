package com.guriarte.librarydemo.cli.actions.listauthors;

import com.guriarte.librarydemo.cli.actions.Action;
import com.guriarte.librarydemo.cli.actions.common.messages.ListAuthorsMessage;
import com.guriarte.librarydemo.cli.actions.common.messages.SimpleAuthor;
import com.guriarte.librarydemo.cli.console.ConsolePrinter;
import com.guriarte.librarydemo.cli.console.ConsoleReader;
import com.guriarte.librarydemo.cli.console.IntegerReader;
import com.guriarte.librarydemo.library.service.AuthorService;

public class ListAuthorsAliveInGivenYearAction implements Action {

    public static final int OPTION = 4;
    private final AuthorService authorService;
    private final IntegerReader integerReader;

    public ListAuthorsAliveInGivenYearAction(AuthorService authorService) {
        this.authorService = authorService;
        this.integerReader = new IntegerReader(new ConsoleReader());
    }

    @Override
    public int option() {
        return OPTION;
    }

    @Override
    public String description() {
        return "List authors alive in given year";
    }

    @Override
    public void perform() {
        System.out.print("Insert a year: ");
        var year = integerReader.read(value -> true, "Please insert a valid year", "Please insert a valid year (example: 1450, -399)");

        var optionalAuthors = this.authorService.getAliveAuthors(year);

        if (optionalAuthors.isPresent()) {
            var listAuthorsMessage = new ListAuthorsMessage(optionalAuthors.get().stream().map(SimpleAuthor::fromDomain).toList()).toString();
            ConsolePrinter.println(listAuthorsMessage);
        } else {
            ConsolePrinter.println("Not found alive authors for year " + year + ".");
        }
    }
}
