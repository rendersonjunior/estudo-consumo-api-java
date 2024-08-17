package org.estudo.coinGeckoApi.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.estudo.coinGeckoApi.model.CoinGecko;
import org.estudo.coinGeckoApi.model.ValorMoeda;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class CoinGeckoApiService implements ICoinGeckoApiService {

    final HttpClient client = HttpClient.newHttpClient();
    final Gson gson = new Gson();

    @Override
    public void findAllCoins() throws IOException, InterruptedException {
        System.out.println("Carregando a listagem de moedas...");

        final var coinsList = new StringBuilder()
                .append("https://api.coingecko.com/api/v3/coins/list");

        final var requestList = HttpRequest.newBuilder()
                .uri(URI.create(coinsList.toString()))
                .build();

        final HttpResponse<String> responseList = client.send(requestList,
                HttpResponse.BodyHandlers.ofString());

        System.out.println("-------------------");
        System.out.println(responseList.body());
    }

    @Override
    public CoinGecko findCoinById(final String coinName) throws IOException, InterruptedException {
        System.out.println("Carregando o preço da moeda ".concat(coinName).concat("..."));

        final var coinsPrice = new StringBuilder()
                .append("https://api.coingecko.com/api/v3/simple/price")
                .append("?ids=")
                .append(coinName)
                .append("&vs_currencies=usd");

        final var requestPrice = HttpRequest.newBuilder()
                .uri(URI.create(coinsPrice.toString()))
                .build();

        final HttpResponse<String> responsePrice = client.send(requestPrice,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(responsePrice.body());

        // Usando JsonObject:
        // final JsonObject jsonObject = JsonParser.parseString(responsePrice.body()).getAsJsonObject();
        // System.out.println("Valor da ".concat(coinName).concat(": ").concat(String.valueOf(jsonObject.getAsJsonObject(coinName).get("usd"))));

        // Usando Gson:
        final Type type = new TypeToken<Map<String, ValorMoeda>>() {
        }.getType();
        final Map<String, ValorMoeda> moedas = gson.fromJson(responsePrice.body(), type);
        return new CoinGecko(moedas);
    }

}
