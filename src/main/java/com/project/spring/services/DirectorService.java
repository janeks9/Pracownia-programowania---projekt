package com.project.spring.services;

import com.project.spring.entities.Director;
import java.util.List;

public interface DirectorService {

    Director saveDirector(Director director);

    List<Director> getBySurname(String surname);

    Iterable<Director> showAllDirectors();

    void deleteDirector(Integer id);
    Boolean checkIfExists(Integer id);

}
