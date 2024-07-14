package org.estudo.coinGeckoApi.service;

import java.io.IOException;

public interface ICoinGeckoApiService {

    void findCoinById(final String coinName) throws IOException, InterruptedException;

}
