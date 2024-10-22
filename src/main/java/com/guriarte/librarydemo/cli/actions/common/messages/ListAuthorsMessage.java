package com.guriarte.librarydemo.cli.actions.common.messages;

import com.guriarte.librarydemo.utils.Text;

import java.util.List;

public class ListAuthorsMessage {

    private final List<SimpleAuthor> authors;
    private static final String AUTHOR_FORMAT = "%d.\t%s";
    private static final String AUTHORS_FOUND_FORMAT = "Authors found (%d): ";

    public ListAuthorsMessage(List<SimpleAuthor> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        var text = new Text();
        text.appendln("Id \t Title");
        text.appendln(String.format(AUTHORS_FOUND_FORMAT, authors.size()));
        for (int i = 0; i < authors.size(); i++) {
            text.appendln(String.format(AUTHOR_FORMAT, i + 1, authors.get(i).name()));
        }
        return text.toString();
    }
}
