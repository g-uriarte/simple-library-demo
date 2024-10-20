package com.guriarte.librarydemo.library.repository;

import com.guriarte.librarydemo.library.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
