package com.guriarte.librarydemo;

import com.guriarte.librarydemo.cli.App;
import com.guriarte.librarydemo.library.service.AuthorService;
import com.guriarte.librarydemo.library.service.BookGutendexService;
import com.guriarte.librarydemo.library.service.BookService;
import com.guriarte.librarydemo.library.service.LanguageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibrarydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarydemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			BookGutendexService bookGutendexService, BookService bookService,
			AuthorService authorService, LanguageService languageService
	) {
		return args -> {
			var app = new App(bookGutendexService, bookService, authorService, languageService);
			app.init();
		};
	}

}
