package com.guriarte.librarydemo.library.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@SequenceGenerator(name = "author_seq", sequenceName = "author_sequence", allocationSize = 1)
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "death_year")
    private Integer deathYear;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

}
