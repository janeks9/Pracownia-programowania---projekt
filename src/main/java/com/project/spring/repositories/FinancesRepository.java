package com.project.spring.repositories;

import com.project.spring.entities.Finances;
import org.springframework.data.repository.CrudRepository;

public interface FinancesRepository extends CrudRepository<Finances, Integer> {
}
