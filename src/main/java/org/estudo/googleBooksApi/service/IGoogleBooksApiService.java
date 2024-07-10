package org.estudo.googleBooksApi.service;

import java.io.IOException;

public interface IGoogleBooksApiService {

    void findBookByName(final String name) throws IOException, InterruptedException;

}
