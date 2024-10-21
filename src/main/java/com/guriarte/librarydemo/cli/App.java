package com.guriarte.librarydemo.cli;

import com.guriarte.librarydemo.cli.actions.*;
import com.guriarte.librarydemo.errors.LibraryBaseException;
import com.guriarte.librarydemo.library.service.AuthorService;
import com.guriarte.librarydemo.library.service.BookGutendexService;
import com.guriarte.librarydemo.library.service.BookService;
import com.guriarte.librarydemo.library.service.LanguageService;

import java.util.*;

public class App {

    private final BookGutendexService bookGutendexService;
    private final BookService bookService;
    private final AuthorService authorService;
    private final LanguageService languageService;
    private final Scanner scanner;

    public App(
            BookGutendexService bookGutendexService, BookService bookService,
            AuthorService authorService, LanguageService languageService
    ) {
        this.bookGutendexService = bookGutendexService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.languageService = languageService;
        this.scanner = new Scanner(System.in);
    }

    public void init() {
        Map<Integer, Action> actions = new HashMap<>();
        actions.put(SearchBookAction.OPTION, new SearchBookAction(bookGutendexService, bookService));
        actions.put(ListRegisteredBooksAction.OPTION, new ListRegisteredBooksAction(bookService));
        actions.put(ListRegisteredAuthorsAction.OPTION, new ListRegisteredAuthorsAction(authorService));
        actions.put(ListAuthorsAliveInGivenYearAction.OPTION, new ListAuthorsAliveInGivenYearAction(authorService));
        actions.put(ListBooksByLanguageActions.OPTION, new ListBooksByLanguageActions(bookService, languageService));
        actions.put(ExitAction.OPTION, new ExitAction());

        Set<Integer> options = actions.keySet();
        List<String> titles = actions.values().stream().map(action -> action.option() + ". " + action.description()).toList();

        int option = 0;
        do {
            try {
                option = selectOption(options, titles);
                actions.get(option).perform();
            } catch (LibraryBaseException e) {
                System.out.println(e.getMessage());
            }
        } while (option != ExitAction.OPTION);
    }

    private int selectOption(Set<Integer> options, List<String> titleOptions) {
        System.out.println("---- Menu ----");
        titleOptions.forEach(System.out::println);
        System.out.print("Select an option: ");
        int option = 0;
        boolean valid = false;
        while (!valid) {
            try {
                option = scanner.nextInt();
                valid = options.contains(option);
                if (!valid) {
                    System.out.println("Please insert a valid option: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please insert a valid option (1, 2, 3...)");
                scanner.nextLine();
            }
        }

        return option;
    }

}
