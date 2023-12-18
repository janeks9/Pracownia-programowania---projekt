package com.project.spring.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.project.spring.entities.Film;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer>, PagingAndSortingRepository<Film, Integer> {

    @Query("Select f from Film f where f.dlugosc > 160")
    List<Film> longFilms();

    @Query("Select f from Film f where f.title = :title")
    List<Film> getByTitle(@Param("title") String title);

}
