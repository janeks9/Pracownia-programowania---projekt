package com.project.spring.services;

import com.project.spring.entities.Film;
import java.util.List;

public interface FilmService {
    Film saveFilm(Film film);

    List<Film> getByTitle(String title);

    Iterable<Film> showAllFilms();

    void deleteFilm(Integer id);

    Boolean checkIfExists(Integer id);

}
