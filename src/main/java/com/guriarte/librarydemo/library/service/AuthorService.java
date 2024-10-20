package com.guriarte.librarydemo.library.service;

import com.guriarte.librarydemo.library.domain.Author;
import com.guriarte.librarydemo.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<List<Author>> getAliveAuthors(int year) {
        return Optional.of(this.authorRepository.findAliveInGivenYear(year));
    }



}
