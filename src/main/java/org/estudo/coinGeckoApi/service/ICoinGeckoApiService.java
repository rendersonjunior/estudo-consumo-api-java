package org.estudo.coinGeckoApi.service;

import org.estudo.coinGeckoApi.model.CoinGecko;

import java.io.IOException;

public interface ICoinGeckoApiService {

    void findAllCoins() throws IOException, InterruptedException;

    CoinGecko findCoinById(final String coinName) throws IOException, InterruptedException;

}
