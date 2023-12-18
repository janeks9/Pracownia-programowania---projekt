package com.project.spring.repositories;

import com.project.spring.entities.Director;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DirectorRepository extends CrudRepository<Director, Integer> {

    List<Director> findBySurname(String surname);

    /*@Query("Select d from ")
    List<Director> moreThan2();*/
}
