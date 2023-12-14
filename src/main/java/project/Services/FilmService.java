package project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.Entities.Film;
import project.Repositories.FilmRepository;

public interface FilmService {
    Film saveFilm(Film film);

}
