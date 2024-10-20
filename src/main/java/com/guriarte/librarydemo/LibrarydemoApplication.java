package com.guriarte.librarydemo;

import com.guriarte.librarydemo.cli.App;
import com.guriarte.librarydemo.library.service.BookGutendexService;
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
	CommandLineRunner commandLineRunner(BookGutendexService bookGutendexService) {
		return args -> {
			var app = new App(bookGutendexService);
			app.init();
		};
	}

}
