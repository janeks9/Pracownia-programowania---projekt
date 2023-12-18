package com.project.spring.services;

import com.project.spring.entities.Finances;
import com.project.spring.repositories.FinancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class FinancesServiceImpl implements FinancesService{
    @Autowired
    private FinancesRepository financesRepository;

    @Override
    public Finances saveFinances(Finances finances){return financesRepository.save(finances);}

    @Override
    public Optional<Finances> getById(Integer id){
        return financesRepository.findById(id);
    }

    @Override
    public Iterable<Finances> showAllFinances(){
        return financesRepository.findAll();
    }

    @Override
    public void deleteFinances(Integer id){
        financesRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(Integer id) {
        if (financesRepository.existsById(id)) {
            return true;
        } else
            return false;
    }
}
