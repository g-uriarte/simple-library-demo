package com.guriarte.librarydemo.library.domain.mapper;

import com.guriarte.librarydemo.library.domain.Author;
import com.guriarte.librarydemo.library.dto.AuthorDto;

public class AuthorMapper {

    public static Author fromAuthorDto(AuthorDto authorDto) {
        var authorDomain = new Author();
        authorDomain.setName(authorDto.name());
        authorDomain.setBirthYear(authorDto.birthYear());
        authorDomain.setDeathYear(authorDto.deathYear());

        return authorDomain;
    }

}
