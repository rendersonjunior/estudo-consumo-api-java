package org.estudo.gitHubApi.service;

import java.io.IOException;

public interface IGitHubService {

    void findUserByName(final String username) throws IOException, InterruptedException;

}
