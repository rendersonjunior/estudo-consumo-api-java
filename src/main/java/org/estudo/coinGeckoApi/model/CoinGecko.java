package org.estudo.coinGeckoApi.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.estudo.util.IGerarArquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public record CoinGecko(Map<String, ValorMoeda> moedas) implements IGerarArquivo {

    @Override
    public void gerarArquivoTxt(String tituloArquivo) {
        try (final var fileWriter = new FileWriter(tituloArquivo.concat(".txt"))) {

            for (final var moeda : moedas.entrySet()) {
                fileWriter.write(moeda.getKey().concat("= ".concat(moeda.getValue().toString())));
            }

        } catch (IOException ex) {
            System.out.println("Erro ao gerar Arquivo: ".concat(ex.getMessage()));
        }
    }

    @Override
    public void gerarArquivoJson(String tituloArquivo) {
        try (final var fileWriter = new FileWriter(tituloArquivo.concat(".json"))) {
            final Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();

            fileWriter.write(gson.toJson(this));
        } catch (IOException ex) {
            System.out.println("Erro ao gerar Arquivo: ".concat(ex.getMessage()));
        }

    }

}
