package org.estudo.googleBooksApi.model;

import org.estudo.util.IGerarArquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public record GoogleBook(String totalItems,
                         List<Item> items) implements IGerarArquivo {

    @Override
    public void gerarArquivoTxt(final String tituloArquivo) {
        try (final var fileWriter = new FileWriter(tituloArquivo.concat(".txt"))) {

            fileWriter.write("QtdeItens: ".concat(this.totalItems()));
            for (final var item : items) {

                final var id = Optional.ofNullable(item.id()).orElse("N/A");
                final var title = Optional.ofNullable(item.volumeInfo().title()).orElse("N/A");
                final var authors = Optional.ofNullable(item.volumeInfo().authors())
                        .map(Object::toString)
                        .orElse("N/A");
                final var description = Optional.ofNullable(item.volumeInfo().description()).orElse("N/A");
                final var pageCount = Optional.ofNullable(item.volumeInfo().pageCount())
                        .map(Object::toString)
                        .orElse("N/A");
                final var publishedDate = Optional.ofNullable(item.volumeInfo().publishedDate()).orElse("N/A");

                final var output = String.format("id: %s%n"
                                .concat("Título: %s%n")
                                .concat("Autores: %s%n")
                                .concat("Descrição: %s%n")
                                .concat("QtdePaginas: %s%n")
                                .concat("DataPublicação: %s%n%n")
                                , id, title, authors, description, pageCount, publishedDate);

                fileWriter.write(output);
            }

            System.out.println("Gerado arquivo ".concat(tituloArquivo));
        } catch (IOException ex) {
            System.out.println("Erro ao gerar Arquivo: ".concat(ex.getMessage()));
        }
    }
}
