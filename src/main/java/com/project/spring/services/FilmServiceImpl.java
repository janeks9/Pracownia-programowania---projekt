package com.project.spring.services;

import com.project.spring.entities.Film;
import com.project.spring.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService{
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Film saveFilm(Film film){
        return filmRepository.save(film);
    }

    @Override
    public List<Film> getByTitle(String title){
        return filmRepository.findByTitle(title);
    }

    @Override
    public Iterable<Film> showAllFilms(){
        return filmRepository.findAll();
    }

    @Override
    public void deleteFilm(Integer id){
        filmRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(Integer id) {
        if (filmRepository.existsById(id)) {
            return true;
        } else
            return false;
    }
}
