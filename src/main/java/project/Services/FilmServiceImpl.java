package project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.Entities.Film;
import project.Repositories.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService{
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Film saveFilm(Film film){
        return filmRepository.save(film);
    }
}
