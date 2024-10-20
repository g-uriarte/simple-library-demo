package com.guriarte.librarydemo.library.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "languages")
@Data
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "languages")
    private Set<Book> books = new HashSet<>();

}
