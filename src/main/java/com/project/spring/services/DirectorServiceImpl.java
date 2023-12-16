package com.project.spring.services;

import com.project.spring.entities.Director;
import com.project.spring.entities.Film;
import com.project.spring.repositories.DirectorRepository;
import com.project.spring.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService{

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public Director saveDirector(Director director){
        return directorRepository.save(director);
    }
}
