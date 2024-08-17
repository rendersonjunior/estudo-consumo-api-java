package org.estudo.theMealDB.service;

import org.estudo.theMealDB.model.TheMealDB;

import java.io.IOException;

public interface ITheMealDBService {

    TheMealDB findRecipeByName(final String name) throws IOException, InterruptedException;

}
