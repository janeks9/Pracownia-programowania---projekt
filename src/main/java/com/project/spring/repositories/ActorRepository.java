package com.project.spring.repositories;

import com.project.spring.entities.Actor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Integer>, PagingAndSortingRepository<Actor, Integer> {

    List<Actor> findBySurname(String surname);

    @Query("Select a from Actor a order by a.surname ASC")
    Iterable<Actor> getAll(PageRequest pageRequest);
}
