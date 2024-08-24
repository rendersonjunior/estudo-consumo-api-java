package org.estudo.gitHubApi.model;

import com.google.gson.annotations.SerializedName;
import org.estudo.util.IGerarArquivo;

import java.io.FileWriter;
import java.io.IOException;

public record UserGit (
        String login,
        Integer id,
        @SerializedName("node_id") String nodeId,
        @SerializedName("avatar_url") String avatarUrl,
        @SerializedName("gravatar_id") String gravatarId,
        String url,
        @SerializedName("html_url") String htmlUrl,
        @SerializedName("followers_url") String followersUrl,
        @SerializedName("following_url") String followingUrl,
        @SerializedName("gists_url") String gistsUrl,
        @SerializedName("starred_url") String starredUrl,
        @SerializedName("subscriptions_url") String subscriptionsUrl,
        @SerializedName("organizations_url") String organizationsUrl,
        @SerializedName("repos_url") String reposUrl,
        @SerializedName("events_url") String eventsUrl,
        @SerializedName("received_events_url") String receivedEventsUrl,
        String type,
        @SerializedName("site_admin") Boolean siteAdmin,
        String name,
        String company,
        String blog,
        String location,
        String email,
        String hireable,
        String bio,
        @SerializedName("twitter_username") String twitterUsername,
        @SerializedName("public_repos") Integer publicRepos,
        @SerializedName("public_gists") Integer publicGists,
        Integer followers,
        Integer following,
        @SerializedName("created_at") String createdAt,
        @SerializedName("updated_at") String updatedAt
) implements IGerarArquivo {

    @Override
    public void gerarArquivoTxt(String tituloArquivo) {
        try (final var fileWriter = new FileWriter("/src/tmp/".concat(tituloArquivo.concat(".txt")))) {

        fileWriter.write("Login: ".concat(this.login)
                        .concat("Email: ")
                        .concat(this.email)
                        .concat("Avatar: ")
                        .concat(this.avatarUrl)
                        .concat("Url: ")
                        .concat(this.url));

        } catch (IOException ex) {
            System.out.println("Erro ao gerar Arquivo: ".concat(ex.getMessage()));
        }

    }
}
