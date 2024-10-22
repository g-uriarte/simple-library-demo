package com.guriarte.librarydemo.cli.actions.common.messages;

import com.guriarte.librarydemo.utils.Text;

import java.util.List;

public class ListBooksMessage {

    private final List<SimpleBook> books;
    private static final String BOOK_FORMAT = "%d.\t%s";
    private static final String BOOKS_FOUND_FORMAT = "Books found (%s): ";

    public ListBooksMessage(List<SimpleBook> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        var text = new Text();
        text.appendln("Id \t Title");
        text.appendln(String.format(BOOKS_FOUND_FORMAT, books.size()));
        for (int i = 0; i < books.size(); i++) {
            text.appendln(String.format(BOOK_FORMAT, i + 1, books.get(i).title()));
        }
        return text.toString();
    }
}
