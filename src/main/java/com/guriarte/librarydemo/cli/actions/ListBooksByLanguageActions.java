package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.cli.console.ConsolePrinter;
import com.guriarte.librarydemo.cli.console.ConsoleReader;
import com.guriarte.librarydemo.cli.console.IntegerReader;
import com.guriarte.librarydemo.errors.LibraryBaseException;
import com.guriarte.librarydemo.library.service.BookService;
import com.guriarte.librarydemo.library.service.LanguageService;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListBooksByLanguageActions implements Action {

    public static final int OPTION = 5;
    private final BookService bookService;
    private final LanguageService languageService;
    private final IntegerReader integerReader;

    public ListBooksByLanguageActions(BookService bookService, LanguageService languageService) {
        this.bookService = bookService;
        this.languageService = languageService;
        this.integerReader = new IntegerReader(new ConsoleReader());
    }

    @Override
    public int option() {
        return OPTION;
    }

    @Override
    public String description() {
        return "List books by language";
    }

    @Override
    public void perform() throws LibraryBaseException {
        var optionalLanguages = this.languageService.getAll();

        if (optionalLanguages.isPresent()) {
            ConsolePrinter.println("Please select one language by id: ");
            var languages = optionalLanguages.get();
            var mapLanguages = IntStream.range(0, languages.size()).boxed().collect(Collectors.toMap(Function.identity(), languages::get));
            var options = mapLanguages.keySet();
            for (int i = 0; i < mapLanguages.size(); i++) {
                System.out.println(i + ". " + mapLanguages.get(i).getName());
            }
            ConsolePrinter.print("language id: ");
            var languageId = integerReader.read(options::contains, "Please insert a valid option", "Please insert a valid option (example: 1, 2, 3...)");

            var selectedLanguage = mapLanguages.get(languageId);
            var optionalBooks = this.bookService.getByLanguage(selectedLanguage.getName());

            if (optionalBooks.isPresent()) {
                optionalBooks
                    .get()
                    .forEach(book -> System.out.println("id: " + book.getId() + " | name: " + book.getTitle()));
            } else {
                ConsolePrinter.println("No books found for the language " + selectedLanguage.getName());
            }
        } else {
            ConsolePrinter.println("Please first register books.");
        }
    }
}
