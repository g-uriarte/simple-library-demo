package com.guriarte.librarydemo.library.service;

import com.guriarte.librarydemo.http.HttpClient;
import com.guriarte.librarydemo.library.dto.Book;
import com.guriarte.librarydemo.library.dto.BooksResponse;
import com.guriarte.librarydemo.utils.DataMapper;
import com.guriarte.librarydemo.utils.URI;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class BookGutendexService {

    private final HttpClient httpClient;
    private final String BASE_URL = "https://gutendex.com";
    private final DataMapper dataMapper = new DataMapper();

    public BookGutendexService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String ping() {
        return "pong";
    }

    public Optional<List<Book>> searchByName(String name) throws GutendexOutOfService {
        try {
            String url = BASE_URL + "/books/?search=" + URI.encodeURLPathComponent(name);
            HttpResponse<String> httpResponse = this.httpClient.get(url);
            if (httpResponse.statusCode() != 200) return Optional.empty();
            var booksResponse = dataMapper.toObject(httpResponse.body(), BooksResponse.class);
            return Optional.of(booksResponse.books());
        } catch (IOException | InterruptedException e) {
            throw new GutendexOutOfService();
        }
    }

}
