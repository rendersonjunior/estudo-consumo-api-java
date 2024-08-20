package org.estudo.gitHubApi.service;

import org.estudo.gitHubApi.model.UserGit;

import java.io.IOException;

public interface IGitHubService {

    UserGit findUserByName(final String username) throws IOException, InterruptedException;

}
