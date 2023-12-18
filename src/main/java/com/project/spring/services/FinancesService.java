package com.project.spring.services;

import com.project.spring.entities.Finances;
import java.util.Optional;

public interface FinancesService {
    Finances saveFinances(Finances finances);

    Optional<Finances> getById(Integer id);

    Iterable<Finances> showAllFinances();

    void deleteFinances(Integer id);

    Boolean checkIfExists(Integer id);
}
