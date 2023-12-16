package com.project.spring.repositories;
import org.springframework.data.repository.CrudRepository;
import com.project.spring.entities.Film;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {

}
