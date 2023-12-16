package com.project.spring.services;

import com.project.spring.entities.Actor;
import com.project.spring.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public Actor saveActor(Actor actor){return actorRepository.save(actor);}
}
