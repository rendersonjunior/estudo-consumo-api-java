package org.estudo;


import org.estudo.coinGeckoApi.service.CoinGeckoApiService;
import org.estudo.coinGeckoApi.service.ICoinGeckoApiService;
import org.estudo.gitHubApi.exception.ErroConsultaGitHubException;
import org.estudo.gitHubApi.service.GitHubService;
import org.estudo.gitHubApi.service.IGitHubService;
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
    final static IGitHubService gitHubService = new GitHubService();

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        var opcao = "";
        do {
            System.out.println("### --------------------- ###");
            System.out.println("Selecione o tipo de servico api que deseja consumir: ");
            System.out.println("1 - Google Books");
            System.out.println("2 - Coin Gecko");
            System.out.println("3 - The MealDB");
            System.out.println("4 - GitHub");
            System.out.println("0 - Sair");
            System.out.println("-----");
            opcao = scanner.nextLine();

            try {
                switch (opcao) {
                    case "1":
                        System.out.println("Escreva o nome do livro:\t");
                        final var nomeLivro = scanner.nextLine();
                        final var responseGoogleBooks = googleBooksApiService.findBookByName(nomeLivro);
                        System.out.println(responseGoogleBooks.toString());
                        responseGoogleBooks.gerarArquivoTxt(nomeLivro);
                        responseGoogleBooks.gerarArquivoJson(nomeLivro);
                        break;
                    case "2":
                        coinGeckoApiService.findAllCoins();
                        System.out.println("---------------");
                        System.out.println("Escreva o id da coin:\t (conforme /coins/list da documentacao)");
                        final var idMoeda = scanner.nextLine();
                        final var responseCoinGecko = coinGeckoApiService.findCoinById(idMoeda);
                        System.out.println(responseCoinGecko.toString());
                        responseCoinGecko.gerarArquivoTxt(idMoeda);
                        responseCoinGecko.gerarArquivoJson(idMoeda);
                        break;
                    case "3":
                        System.out.println("Escreva o nome da receita:\t");
                        final var nomeReceita = scanner.nextLine();
                        final var responseTheMealDB = theMealDBService.findRecipeByName(nomeReceita);
                        System.out.println(responseTheMealDB.toString());
                        responseTheMealDB.gerarArquivoTxt(nomeReceita);
                        responseTheMealDB.gerarArquivoJson(nomeReceita);
                        break;
                    case "4":
                        System.out.println("Escreva o nome do usuário do github:\t");
                        final var nomeUsuario = scanner.nextLine();
                        final var responseGitHub = gitHubService.findUserByName(nomeUsuario);
                        System.out.println(responseGitHub.toString());
                        responseGitHub.gerarArquivoTxt(nomeUsuario);
                        responseGitHub.gerarArquivoJson(nomeUsuario);
                        break;
                    case "0":
                        System.out.println("Encerrando aplicação...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (ErroConsultaGitHubException ex) {
                System.out.println("Erro na consulta ao GitHub: ".concat(ex.getMessage()));
            } catch (IOException | InterruptedException ex) {
                System.out.println("Erro: ".concat(ex.getMessage()));
            }
        } while (!"0".equals(opcao));

    }

}