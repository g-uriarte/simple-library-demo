package com.guriarte.librarydemo.cli.actions;

import com.guriarte.librarydemo.errors.LibraryBaseException;
import com.guriarte.librarydemo.library.domain.mapper.BookMapper;
import com.guriarte.librarydemo.library.service.BookGutendexService;
import com.guriarte.librarydemo.library.service.BookService;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SearchBookAction implements Action {

    private final BookGutendexService bookGutendexService;
    private final BookService bookService;
    public static final int OPTION = 1;

    public SearchBookAction(
            BookGutendexService bookGutendexService,
            BookService bookService
    ) {
        this.bookGutendexService = bookGutendexService;
        this.bookService = bookService;
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
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert a book name: ");
        var bookTitle = sc.nextLine();
        System.out.println("Searching...");
        var optionalBooks = bookGutendexService.searchByName(bookTitle);
        if (optionalBooks.isPresent()) {
            var books = optionalBooks.get();
            System.out.println("Books found (" +books.size()+  "): ");
            IntStream.range(0, books.size()).forEach(i -> {
                System.out.println(i + 1 + ". " + books.get(i).title());
            });
            System.out.print("Select a book by id: ");
            var bookIndex = sc.nextInt();
            var selectedBook = books.get(bookIndex - 1);
            var book = bookService.save(BookMapper.fromDto(selectedBook));
            System.out.println("Book "+ book.getTitle() +" saved!");
        } else {
            System.out.println("Not found books with title: " + bookTitle);
        }
    }
}
