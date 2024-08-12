package org.estudo;


import org.estudo.coinGeckoApi.service.CoinGeckoApiService;
import org.estudo.coinGeckoApi.service.ICoinGeckoApiService;
import org.estudo.googleBooksApi.service.GoogleBooksApiService;
import org.estudo.googleBooksApi.service.IGoogleBooksApiService;
import org.estudo.theMealDB.service.ITheMealDBService;
import org.estudo.theMealDB.service.TheMealDBService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    final static IGoogleBooksApiService googleBooksApiService = new GoogleBooksApiService();
    final static ICoinGeckoApiService coinGeckoApiService = new CoinGeckoApiService();
    final static ITheMealDBService theMealDBService = new TheMealDBService();

    public static void main(String[] args) throws IOException, InterruptedException {
        final var scanner = new Scanner(System.in);
        var opcao = "";
        do {
            System.out.println("Selecione o tipo de servico api que deseja consumir: ");
            System.out.println("1 - Google Books");
            System.out.println("2 - Coin Gecko");
            System.out.println("3 - The MealDB");
            System.out.println("0 - Sair");
            System.out.println("-----");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Escreva o nome do livro:\t");
                    final var nomeLivro = scanner.nextLine();
                    googleBooksApiService.findBookByName(nomeLivro);
                    break;
                case "2":
                    System.out.println("Escreva o id da coin:\t (conforme /coins/list da documentacao)");
                    final var idMoeda = scanner.nextLine();
                    coinGeckoApiService.findCoinById(idMoeda);
                    break;
                case "3":
                    System.out.println("Escreva o nome da receita:\t");
                    final var nomeReceita = scanner.nextLine();
                    theMealDBService.findRecipeByName(nomeReceita);
                    break;
                case "0":
                    System.out.println("Encerrando aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (!"0".equals(opcao));
    }

}