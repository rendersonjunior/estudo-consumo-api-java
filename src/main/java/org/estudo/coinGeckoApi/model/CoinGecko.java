package org.estudo.coinGeckoApi.model;

import org.estudo.util.IGerarArquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public record CoinGecko(Map<String, ValorMoeda> moedas) implements IGerarArquivo {

    @Override
    public void gerarArquivoTxt(String tituloArquivo) {
        try (final var fileWriter = new FileWriter("/src/tmp/".concat(tituloArquivo.concat(".txt")))) {

            for (final var moeda : moedas.entrySet()) {
                fileWriter.write(moeda.getKey().concat("= ".concat(moeda.getValue().toString())));
            }

        } catch (IOException ex) {
            System.out.println("Erro ao gerar Arquivo: ".concat(ex.getMessage()));
        }
    }
}
