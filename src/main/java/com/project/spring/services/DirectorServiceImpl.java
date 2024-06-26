package com.project.spring.services;

import com.project.spring.entities.Director;
import com.project.spring.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService{

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public Director saveDirector(Director director){
        return directorRepository.save(director);
    }

    @Override
    public List<Director> getBySurname(String surname){
        return directorRepository.findBySurname(surname);
    }

    @Override
    public Iterable<Director> showAllDirectors(){return directorRepository.findAll();}

    @Override
    public void deleteDirector(Integer id){
        directorRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(Integer id) {
        if (directorRepository.existsById(id)) {
            return true;
        } else
            return false;
    }
}
