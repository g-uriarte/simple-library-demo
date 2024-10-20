package com.guriarte.librarydemo.library.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "languages")
@SequenceGenerator(name = "language_seq", sequenceName = "language_sequence", allocationSize = 1)
@Data
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_seq")
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "languages")
    private Set<Book> books = new HashSet<>();

}
