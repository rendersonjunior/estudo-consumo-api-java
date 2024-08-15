package org.estudo.googleBooksApi.service;

import org.estudo.googleBooksApi.model.GoogleBook;

import java.io.IOException;

public interface IGoogleBooksApiService {

    GoogleBook findBookByName(final String name) throws IOException, InterruptedException;

}
