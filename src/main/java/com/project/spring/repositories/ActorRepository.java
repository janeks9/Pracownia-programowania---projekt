package com.project.spring.repositories;

import com.project.spring.entities.Actor;
import com.project.spring.entities.Director;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

    List<Actor> findBySurname(String surname);
}
