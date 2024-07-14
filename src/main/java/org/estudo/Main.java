package org.estudo;


import org.estudo.coinGeckoApi.service.CoinGeckoApiService;
import org.estudo.coinGeckoApi.service.ICoinGeckoApiService;
import org.estudo.googleBooksApi.service.GoogleBooksApiService;
import org.estudo.googleBooksApi.service.IGoogleBooksApiService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    final static IGoogleBooksApiService googleBooksApiService = new GoogleBooksApiService();
    final static ICoinGeckoApiService coinGeckoApiService = new CoinGeckoApiService();

    public static void main(String[] args) throws IOException, InterruptedException {
        final var scanner = new Scanner(System.in);
        final var query = scanner.nextLine();

        //googleBooksApiService.findBookByName(query);
        coinGeckoApiService.findCoinByName(query);

    }

}