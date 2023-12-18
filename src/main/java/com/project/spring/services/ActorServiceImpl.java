package com.project.spring.services;

import com.project.spring.entities.Actor;
import com.project.spring.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public Actor saveActor(Actor actor){return actorRepository.save(actor);}
    @Override
    public List<Actor> getBySurname(String surname){
        return actorRepository.findBySurname(surname);
    }

    @Override
    public Iterable<Actor> showAllActors(){
        return actorRepository.findAll();
    }

    @Override
    public void deleteActor(Integer id){
        actorRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(Integer id) {
        if (actorRepository.existsById(id)) {
            return true;
        } else
            return false;
    }

    @Override
    public Iterable<Actor> getAll(Integer pageNr, Integer howMany){
        return actorRepository.getAll(PageRequest.of(pageNr, howMany));
    }

}
