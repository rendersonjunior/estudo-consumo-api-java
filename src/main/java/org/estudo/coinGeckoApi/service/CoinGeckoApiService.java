package org.estudo.coinGeckoApi.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CoinGeckoApiService implements ICoinGeckoApiService {

    @Override
    public void findCoinById(final String coinName) throws IOException, InterruptedException {
        System.out.println("Carregando o preço da moeda ".concat(coinName).concat("..."));

        final var endereco = new StringBuilder()
                .append("https://api.coingecko.com/api/v3/simple/price")
                .append("?ids=")
                .append(coinName)
                .append("&vs_currencies=usd");

        final HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco.toString()))
                .build();

        final HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

}
