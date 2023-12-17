package com.project.spring.repositories;

import com.project.spring.entities.Genre;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Integer> {

    List<Genre> findById(int id);
}
