package com.project.spring.services;

import com.project.spring.entities.Film;
import com.project.spring.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService{
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Film saveFilm(Film film){
        return filmRepository.save(film);
    }
}
