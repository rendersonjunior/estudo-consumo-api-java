package org.estudo.gitHubApi.service;

import com.google.api.client.http.HttpStatusCodes;
import com.google.gson.Gson;
import org.estudo.gitHubApi.exception.ErroConsultaGitHubException;
import org.estudo.gitHubApi.model.UserGit;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class GitHubService implements IGitHubService {

    @Override
    public UserGit findUserByName(final String username) throws IOException, InterruptedException {
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

        if (Objects.equals(response.statusCode(), 404)) {
            throw new ErroConsultaGitHubException("Usuário não encontrado!");
        }

        return new Gson().fromJson(response.body(), UserGit.class);
    }

}
