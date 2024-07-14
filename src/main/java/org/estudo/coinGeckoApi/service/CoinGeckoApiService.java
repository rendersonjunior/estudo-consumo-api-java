package org.estudo.coinGeckoApi.service;

public class CoinGeckoApiService implements ICoinGeckoApiService {

    @Override
    public void findCoinByName(final String coinName) {
        System.out.println("Coin".concat(coinName));
    }

}
