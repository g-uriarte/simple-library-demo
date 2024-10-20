package com.guriarte.librarydemo.library.service;

import com.guriarte.librarydemo.library.domain.Book;
import com.guriarte.librarydemo.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book) {
        this.bookRepository.save(book);
    }

    public Optional<List<Book>> getAllBooks() {
        return Optional.of(this.bookRepository.findAll());
    }

    public Optional<List<Book>> getByLanguage(String language) {
        return Optional.of(this.bookRepository.findByLanguage(language));
    }

}
