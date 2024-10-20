package com.guriarte.librarydemo.library.service;

import com.guriarte.librarydemo.library.domain.Language;
import com.guriarte.librarydemo.library.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Optional<List<Language>> getAllLanguages() {
        return Optional.of(this.languageRepository.findAll());
    }

}
