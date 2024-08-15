package org.estudo.googleBooksApi.model;

import java.util.List;

public record GoogleBook(String totalItems,
                         List<Item> items) {
}
