package com.project.spring.services;

import com.project.spring.entities.Genre;
import com.project.spring.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre saveGenre(Genre genre){return genreRepository.save(genre);}

    @Override
    public Optional<Genre> getById(Integer id){
        return genreRepository.findById(id);
    }

    @Override
    public Iterable<Genre> showAllGenres(){
        return genreRepository.findAll();
    }

    @Override
    public void deleteGenre(Integer id){
        genreRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(Integer id) {
        if (genreRepository.existsById(id)) {
            return true;
        } else
            return false;
    }
}
