package org.estudo.googleBooksApi.service;

import com.google.gson.Gson;
import org.estudo.googleBooksApi.model.GoogleBook;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class GoogleBooksApiService implements IGoogleBooksApiService {

    @Override
    public GoogleBook findBookByName(final String name) throws IOException, InterruptedException {
        System.out.println("Carregando livro...");

        final var endereco = new StringBuilder()
                .append("https://www.googleapis.com/books/v1/volumes")
                .append("?q=")
                .append(URLEncoder.encode(name, StandardCharsets.UTF_8));

        final HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco.toString()))
                .build();

        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), GoogleBook.class);
    }

}
