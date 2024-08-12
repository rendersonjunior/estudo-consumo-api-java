package org.estudo.theMealDB.service;

import java.io.IOException;

public interface ITheMealDBService {

    void findRecipeByName(final String name) throws IOException, InterruptedException;

}
