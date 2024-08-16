package org.estudo.coinGeckoApi.model;

import java.util.Map;

public record CoinGecko(Map<String, ValorMoeda> value) {
}
