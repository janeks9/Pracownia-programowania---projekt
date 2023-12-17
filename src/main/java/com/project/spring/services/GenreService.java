package com.project.spring.services;

import com.project.spring.entities.Genre;

import java.util.Optional;

public interface GenreService {
    Genre saveGenre(Genre genre);
    Optional<Genre> getById(Integer id);

    Iterable<Genre> showAllGenres();

    void deleteGenre(Integer id);

    Boolean checkIfExists(Integer id);
}
