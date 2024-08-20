package org.estudo.gitHubApi.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubService implements IGitHubService {

    @Override
    public void findUserByName(final String username) throws IOException, InterruptedException {
        System.out.println("Consultando usuário do GitHub...");

        final var endereco = new StringBuilder()
                .append("https://api.github.com/users/")
                .append(username);

        final HttpClient client = HttpClient.newHttpClient();

        final HttpRequest request = HttpRequest.newBuilder()
                .header("Accept", "application/vnd.github+json")
                .uri(URI.create(endereco.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response);

    }

}
