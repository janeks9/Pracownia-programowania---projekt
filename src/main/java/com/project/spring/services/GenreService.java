package com.project.spring.services;

import com.project.spring.entities.Genre;
import java.util.List;

public interface GenreService {
    Genre saveGenre(Genre genre);
    List<Genre> getById(int id);
}
