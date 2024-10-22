package com.guriarte.librarydemo.library.repository;

import com.guriarte.librarydemo.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b JOIN b.languages l WHERE l.name = :languageName")
    List<Book> findByLanguage(@Param("languageName") String language);

    boolean existsByTitle(String title);

}
