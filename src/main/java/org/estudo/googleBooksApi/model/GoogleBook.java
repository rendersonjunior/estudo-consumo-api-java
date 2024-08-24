package org.estudo.googleBooksApi.model;

import org.estudo.util.IGerarArquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public record GoogleBook(String totalItems,
                         List<Item> items) implements IGerarArquivo {

    @Override
    public void gerarArquivoTxt(String tituloArquivo) {
        try (final var fileWriter = new FileWriter("/src/tmp/".concat(tituloArquivo.concat(".txt")))) {

            fileWriter.write("QtdeItens: ".concat(this.totalItems()));
            for (final var item : items ) {
                fileWriter.write("id: ".concat(item.id())
                        .concat("Título: ").concat(item.volumeInfo().title())
                        .concat("Autores: ").concat(item.volumeInfo().authors().toString())
                        .concat("Descrição: ").concat(item.volumeInfo().description())
                        .concat("QtdePaginas: ").concat(item.volumeInfo().pageCount())
                        .concat("DataPublicação: ").concat(item.volumeInfo().publishedDate()));
            }

            System.out.println("Gerado arquivo".concat(tituloArquivo));
        } catch (IOException ex) {
            System.out.println("Erro ao gerar Arquivo: ".concat(ex.getMessage()));
        }
    }
}
