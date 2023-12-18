package com.project.spring.repositories;

import com.project.spring.entities.Finances;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FinancesRepository extends CrudRepository<Finances, Integer> {

    @Query("Select f.id from Finances f where f.budget>100")
    List<Finances> budget(Integer id);
}
