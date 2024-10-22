package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.cli.actions.common.messages.ListBookMessage;
import com.guriarte.librarydemo.cli.actions.common.messages.SimpleBook;
import com.guriarte.librarydemo.cli.console.ConsolePrinter;
import com.guriarte.librarydemo.cli.console.ConsoleReader;
import com.guriarte.librarydemo.cli.console.IntegerReader;
import com.guriarte.librarydemo.cli.console.StringReader;
import com.guriarte.librarydemo.errors.LibraryBaseException;
import com.guriarte.librarydemo.library.domain.mapper.BookMapper;
import com.guriarte.librarydemo.library.dto.BookDto;
import com.guriarte.librarydemo.library.service.BookGutendexService;
import com.guriarte.librarydemo.library.service.BookService;

import java.util.stream.IntStream;

public class SearchBookAction implements Action {

    private final BookGutendexService bookGutendexService;
    private final BookService bookService;

    private final StringReader stringReader;
    private final IntegerReader integerReader;

    public static final int OPTION = 1;

    public SearchBookAction(
            BookGutendexService bookGutendexService,
            BookService bookService
    ) {
        this.bookGutendexService = bookGutendexService;
        this.bookService = bookService;
        var sc = new ConsoleReader();
        this.stringReader = new StringReader(sc);
        this.integerReader = new IntegerReader(sc);
    }

    @Override
    public int option() {
        return OPTION;
    }

    @Override
    public String description() {
        return "Search book by title";
    }

    @Override
    public void perform() throws LibraryBaseException {
        ConsolePrinter.print("Insert a book name: ");
        var bookTitle = stringReader.read(value -> !value.isBlank(), "Please insert a valid title", "Please insert a valid title (example: Hunger games)");
        ConsolePrinter.println("Searching...");
        var optionalBooks = bookGutendexService.searchByName(bookTitle);
        if (optionalBooks.isPresent() && !optionalBooks.get().isEmpty()) {
            var books = optionalBooks.get();
            var booksOptions = IntStream.range(0, books.size()).boxed().toList();
            var booksMessage = new ListBookMessage(books.stream().map(SimpleBook::fromDto).toList());
            ConsolePrinter.println(booksMessage.toString());
            ConsolePrinter.print("Select a book by id: ");
            var bookIndex = integerReader.read(booksOptions::contains, "Please insert a valid book id", "Please insert a valid book id (example: 0, 1, 2 ...)");
            var selectedBook = books.get(bookIndex - 1);

            if (isBookAlreadyRegistered(selectedBook)) {
                ConsolePrinter.println("Selected book is already registered!");
            } else {
                var book = bookService.save(BookMapper.fromDto(selectedBook));
                ConsolePrinter.println("Book '"+ book.getTitle() +"' saved!");
            }

        } else {
            ConsolePrinter.println("Not found books with title: '" + bookTitle+ "'");
        }
    }

    private boolean isBookAlreadyRegistered(BookDto selectedBook) {
        return this.bookService.existsByTitle(selectedBook.title());
    }
}
