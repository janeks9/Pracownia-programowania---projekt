package com.project.spring.services;

import com.project.spring.entities.Finances;
import com.project.spring.repositories.FinancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancesServiceImpl implements FinancesService{
    @Autowired
    private FinancesRepository financesRepository;

    @Override
    public Finances saveFinances(Finances finances){return financesRepository.save(finances);}
}
