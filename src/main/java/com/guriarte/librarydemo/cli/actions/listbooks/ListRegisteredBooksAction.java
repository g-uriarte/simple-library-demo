package com.guriarte.librarydemo.cli.actions.listbooks;

import com.guriarte.librarydemo.cli.actions.Action;
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
    public void perform() throws LibraryBaseException {
        var optionalBooks = this.bookService.getAllBooks();

        if (optionalBooks.isPresent()) {
            optionalBooks.get().forEach(book -> System.out.println(book.getId() + ". " + book.getTitle()));
        } else {
            System.out.println("Not found registered books. Please register a book");
        }

    }
}
