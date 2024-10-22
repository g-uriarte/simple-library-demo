package com.guriarte.librarydemo.library.service;

import com.guriarte.librarydemo.library.domain.Author;
import com.guriarte.librarydemo.library.domain.Book;
import com.guriarte.librarydemo.library.domain.Language;
import com.guriarte.librarydemo.library.repository.AuthorRepository;
import com.guriarte.librarydemo.library.repository.BookRepository;
import com.guriarte.librarydemo.library.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final LanguageRepository languageRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, LanguageRepository languageRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.languageRepository = languageRepository;
    }

    public Book save(Book book) {
        Set<Author> savedAuthors = new HashSet<>();
        book.getAuthors().forEach(author -> {
            var optionalAuthor = authorRepository.findByName(author.getName());
            if (optionalAuthor.isPresent()) {
                savedAuthors.add(optionalAuthor.get());
            } else {
                var authorSaved = authorRepository.save(author);
                savedAuthors.add(authorSaved);
            }
        });
        book.setAuthors(savedAuthors);

        Set<Language> savedLanguages = new HashSet<>();
        book.getLanguages().forEach(language -> {
            var optionalLanguage = languageRepository.findByName(language.getName());
            if (optionalLanguage.isPresent()) {
                savedLanguages.add(optionalLanguage.get());
            } else {
                var languageSaved = languageRepository.save(language);
                savedLanguages.add(languageSaved);
            }
        });

        book.setLanguages(savedLanguages);

        return this.bookRepository.save(book);
    }

    public boolean existsByTitle(String title) {
        return this.bookRepository.existsByTitle(title);
    }

    public Optional<List<Book>> getAllBooks() {
        var books = this.bookRepository.findAll();
        if (books.isEmpty()) return Optional.empty();
        return Optional.of(books);
    }

    public Optional<List<Book>> getByLanguage(String language) {
        return Optional.of(this.bookRepository.findByLanguage(language));
    }

}
