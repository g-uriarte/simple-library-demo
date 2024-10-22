package com.guriarte.librarydemo.cli.actions.common.messages;

import com.guriarte.librarydemo.library.domain.Book;
import com.guriarte.librarydemo.library.dto.BookDto;

public record SimpleBook(String title) {

    public static SimpleBook fromDto(BookDto bookDto) {
        return new SimpleBook(bookDto.title());
    }

    public static SimpleBook fromDomain(Book book) {
        return new SimpleBook(book.getTitle());
    }



}
