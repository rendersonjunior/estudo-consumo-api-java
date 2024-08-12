package org.estudo.googleBooksApi.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GoogleBooksApiService implements IGoogleBooksApiService {

    @Override
    public void findBookByName(String name) throws IOException, InterruptedException {
        System.out.println("Carregando livro...");

        final var endereco = new StringBuilder()
                .append("https://www.googleapis.com/books/v1/volumes")
                .append("?q=")
                .append(name);

        final HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco.toString()))
                .build();

        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

}
