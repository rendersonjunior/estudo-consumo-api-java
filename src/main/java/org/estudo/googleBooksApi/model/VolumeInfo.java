package org.estudo.googleBooksApi.model;

import java.util.List;

public record VolumeInfo(String title,
                         List<String> authors,
                         String publishedDate,
                         String description,
                         String pageCount,
                         String language) {
}
