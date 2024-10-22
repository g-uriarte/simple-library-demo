package com.guriarte.librarydemo.cli.actions.listbooks;

import com.guriarte.librarydemo.cli.actions.Action;
import com.guriarte.librarydemo.cli.actions.common.messages.ListBooksMessage;
import com.guriarte.librarydemo.cli.actions.common.messages.SimpleBook;
import com.guriarte.librarydemo.cli.console.ConsolePrinter;
import com.guriarte.librarydemo.errors.LibraryBaseException;
import com.guriarte.librarydemo.library.service.BookService;

public class ListRegisteredBooksAction implements Action {

    public static final int OPTION = 2;

    private final BookService bookService;

    public ListRegisteredBooksAction(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public int option() {
        return OPTION;
    }

    @Override
    public String description() {
        return "List registered books";
    }

    @Override
    public void perform() {
        var optionalBooks = this.bookService.getAllBooks();

        if (optionalBooks.isPresent()) {
            var listBookMessage = new ListBooksMessage(optionalBooks.get().stream().map(SimpleBook::fromDomain).toList()).toString();
            ConsolePrinter.println(listBookMessage);
        } else {
            ConsolePrinter.println("Not found registered books. Please register a book");
        }

    }
}
