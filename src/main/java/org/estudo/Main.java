package org.estudo;


import org.estudo.googleBooksApi.service.GoogleBooksApiService;
import org.estudo.googleBooksApi.service.IGoogleBooksApiService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    final static IGoogleBooksApiService googleBooksApiService = new GoogleBooksApiService();

    public static void main(String[] args) throws IOException, InterruptedException {
        final var scanner = new Scanner(System.in);
        final var query = scanner.nextLine();

        googleBooksApiService.findBookByName(query);

    }

}