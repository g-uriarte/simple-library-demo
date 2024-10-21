package com.guriarte.librarydemo.library.repository;

import com.guriarte.librarydemo.library.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE a.birthYear <= ?1 AND a.deathYear >= ?1")
    List<Author> findAliveInGivenYear(int year);

    @Query("SELECT a FROM Author a WHERE a.name = :name")
    Optional<Author> findByName(@Param("name") String name);
}
