package com.guriarte.librarydemo.cli.actions.common.messages;

import com.guriarte.librarydemo.library.domain.Author;
import com.guriarte.librarydemo.library.dto.AuthorDto;

public record SimpleAuthor(String name) {

    public static SimpleAuthor fromDto(AuthorDto authorDto) {
        return new SimpleAuthor(authorDto.name());
    }

    public static SimpleAuthor fromDomain(Author author) {
        return new SimpleAuthor(author.getName());
    }

}
