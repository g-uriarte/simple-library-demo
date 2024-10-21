package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.errors.LibraryBaseException;
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
    public void perform() throws LibraryBaseException {
        var optionalAuthors =  this.authorService.getAll();
        if (optionalAuthors.isPresent()) {
            optionalAuthors
                .get()
                .forEach(author -> System.out.println(author.getId() + ". " + author.getName() + " " + author.getBirthYear() + " - " + author.getDeathYear()));
        } else {
            System.out.println("Not found registered authors.");
        }
    }
}
