package com.guriarte.librarydemo.cli;

import com.guriarte.librarydemo.cli.actions.*;
import com.guriarte.librarydemo.errors.LibraryBaseException;
import com.guriarte.librarydemo.library.service.BookGutendexService;

import java.util.*;

public class App {

    private final BookGutendexService bookGutendexService;
    private final Scanner scanner;

    public App(BookGutendexService bookGutendexService) {
        this.bookGutendexService = bookGutendexService;
        this.scanner = new Scanner(System.in);
    }

    public void init() {
        Map<Integer, Action> actions = new HashMap<>();
        actions.put(SearchBookAction.OPTION, new SearchBookAction());
        actions.put(ListRegisteredBooksAction.OPTION, new ListRegisteredBooksAction());
        actions.put(ListRegisteredAuthorsAction.OPTION, new ListRegisteredAuthorsAction());
        actions.put(ListAuthorsAliveInGivenYearAction.OPTION, new ListAuthorsAliveInGivenYearAction());
        actions.put(ListBooksByLanguageActions.OPTION, new ListBooksByLanguageActions());

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
        } while (option != 6);
    }

    private int selectOption(Set<Integer> options, List<String> titleOptions) {
        titleOptions.forEach(System.out::println);
        System.out.print("Select an option: ");
        int option = 0;
        boolean valid = false;
        while (!valid) {
            try {
                option = scanner.nextInt();
                valid = options.contains(option);
            } catch (InputMismatchException e) {
                System.out.println("Please insert a valid option (1, 2, 3...)");
            }
        }

        return option;
    }

}
