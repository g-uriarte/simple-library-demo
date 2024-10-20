package com.guriarte.librarydemo.library.repository;

import com.guriarte.librarydemo.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BookRepository extends JpaRepository<Book, Long> {
}
