package org.estudo.theMealDB.model;

import org.estudo.util.IGerarArquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public record TheMealDB(List<Meal> meals) implements IGerarArquivo {

    @Override
    public void gerarArquivoTxt(String tituloArquivo) {
        try (final var fileWriter = new FileWriter(tituloArquivo.concat(".txt"))) {

            for (final var meal : this.meals()) {
                final var listaIngredientes = new ArrayList<>();
                for (int i=1; i<=10; i++) {
                    try {
                        final Field ingrediente = Meal.class.getDeclaredField("strIngredient".concat(String.valueOf(i)));
                        ingrediente.setAccessible(true);
                        final var nomeIngrediente = ingrediente.get(meal).toString();
                        listaIngredientes.add(nomeIngrediente);
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        break;
                    }
                }

                final var listaAcompanhamentos = new ArrayList<>();
                for (int i=1; i<=10; i++) {
                    try {
                        final Field acompanhamento = Meal.class.getDeclaredField("strMeasure".concat(String.valueOf(i)));
                        acompanhamento.setAccessible(true);
                        listaAcompanhamentos.add(acompanhamento.get(meal).toString());
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        break;
                    }
                }

                fileWriter.write("id: ".concat(meal.idMeal())
                        .concat("\nNome: ").concat(meal.strArea())
                        .concat("\nCategoria: ").concat(meal.strCategory())
                        .concat("\nRegião: ").concat(meal.strArea())
                        .concat("\nImagem: ").concat(String.valueOf(meal.strImageSource()))
                        .concat("\nIngredientes: ".concat(listaIngredientes.toString()))
                        .concat("\nInstruções: ".concat(meal.strInstructions()))
                        .concat("\nPorção: ".concat(listaAcompanhamentos.toString())).concat("\n\n"));
            }

            System.out.println("Gerado arquivo ".concat(tituloArquivo));
        } catch (IOException ex) {
            System.out.println("Erro ao gerar Arquivo: ".concat(ex.getMessage()));
        }

    }

}
