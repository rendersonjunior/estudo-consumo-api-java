package org.estudo.gitHubApi.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;

    public ConfigLoader() throws IOException {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Desculpe, não foi possível encontrar o arquivo application.properties");
                return;
            }

            properties.load(input);
        } catch (IOException ex) {
            throw new IOException();
        }
    }

    public String getTokenGitHubAPI() {
        return properties.getProperty("api.github.token");
    }

}
