package com.guriarte.librarydemo.library.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BooksResponse(
    @JsonAlias("results") List<BookDto> books
) { }
