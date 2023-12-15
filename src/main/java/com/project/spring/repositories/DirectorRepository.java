package com.project.spring.repositories;

import com.project.spring.entities.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Integer> {
}
