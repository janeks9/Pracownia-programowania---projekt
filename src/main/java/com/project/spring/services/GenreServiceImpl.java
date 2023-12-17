package com.project.spring.services;

import com.project.spring.entities.Genre;
import com.project.spring.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre saveGenre(Genre genre){return genreRepository.save(genre);}

    @Override
    public List<Genre> getById(int id){
        return genreRepository.findById(id);
    }
}
