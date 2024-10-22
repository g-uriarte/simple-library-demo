package com.guriarte.librarydemo.cli.actions.listauthors;

import com.guriarte.librarydemo.cli.actions.Action;
import com.guriarte.librarydemo.cli.actions.common.messages.ListAuthorsMessage;
import com.guriarte.librarydemo.cli.actions.common.messages.SimpleAuthor;
import com.guriarte.librarydemo.cli.console.ConsolePrinter;
import com.guriarte.librarydemo.library.service.AuthorService;

public class ListRegisteredAuthorsAction implements Action {

    public static final int OPTION = 3;
    private final AuthorService authorService;

    public ListRegisteredAuthorsAction(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public int option() {
        return OPTION;
    }

    @Override
    public String description() {
        return "List registered authors";
    }

    @Override
    public void perform() {
        var optionalAuthors =  this.authorService.getAll();
        if (optionalAuthors.isPresent()) {
            var listAuthorsMessage = new ListAuthorsMessage(optionalAuthors.get().stream().map(SimpleAuthor::fromDomain).toList()).toString();
            ConsolePrinter.println(listAuthorsMessage);
        } else {
            ConsolePrinter.println("Not found registered authors.");
        }
    }
}
