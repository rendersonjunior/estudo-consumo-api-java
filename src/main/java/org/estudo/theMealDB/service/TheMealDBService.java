package org.estudo.theMealDB.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TheMealDBService implements ITheMealDBService {

    @Override
    public void findRecipeByName(final String name) throws IOException, InterruptedException {
        System.out.println("Carregando Receitas...");

        final var endereco = new StringBuilder()
                .append("https://www.themealdb.com/api/json/v1/1/search.php")
                .append("?s=")
                .append(name);

        final HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco.toString()))
                .build();

        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

}


