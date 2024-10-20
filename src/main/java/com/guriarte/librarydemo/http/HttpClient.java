package com.guriarte.librarydemo.http;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class HttpClient {

    private final java.net.http.HttpClient client;

    public HttpClient() {
        this.client = java.net.http.HttpClient.newHttpClient();
    }

    public HttpResponse<String> get(String url) throws IOException, InterruptedException {
        return this.client.send(createGetRequest(url), HttpResponse.BodyHandlers.ofString());
    }

    private HttpRequest createGetRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }


}
