package com.project.spring.repositories;
import org.springframework.data.repository.CrudRepository;
import com.project.spring.entities.Film;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer>, PagingAndSortingRepository<Film, Integer> {
    List<Film> findByTitle(String title);

}
