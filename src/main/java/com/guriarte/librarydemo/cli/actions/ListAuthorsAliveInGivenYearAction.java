package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.errors.LibraryBaseException;
import com.guriarte.librarydemo.library.service.AuthorService;

import java.util.Scanner;

public class ListAuthorsAliveInGivenYearAction implements Action {

    public static final int OPTION = 4;
    private final AuthorService authorService;

    public ListAuthorsAliveInGivenYearAction(AuthorService authorService) {
        this.authorService = authorService;
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
    public void perform() throws LibraryBaseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert a year: ");
        var year = sc.nextInt();

        var optionalAuthors = this.authorService.getAliveAuthors(year);

        if (optionalAuthors.isPresent()) {
            optionalAuthors
                .get()
                .forEach(author -> System.out.println(author.getId() + ". " + author.getName() + " " + author.getBirthYear() + " - " + author.getDeathYear()));
        } else {
            System.out.println("Not found alive authors for year " + year + ".");
        }



    }
}
