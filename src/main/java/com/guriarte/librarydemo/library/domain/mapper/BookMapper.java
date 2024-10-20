package com.guriarte.librarydemo.library.domain.mapper;

import com.guriarte.librarydemo.library.domain.Book;
import com.guriarte.librarydemo.library.dto.BookDto;

import java.util.stream.Collectors;

public class BookMapper {

    public static Book fromDto(BookDto bookDto) {
        var bookDomain = new Book();
        bookDomain.setTitle(bookDto.title());
        bookDomain.setAuthors(bookDto.authors().stream().map(AuthorMapper::fromAuthorDto).collect(Collectors.toSet()));
        bookDomain.setLanguages(bookDto.languages().stream().map(LanguageMapper::fromPrimitive).collect(Collectors.toSet()));
        return bookDomain;
    }

}
