package com.project.spring.services;

import com.project.spring.entities.Actor;
import java.util.List;

public interface ActorService {
    Actor saveActor(Actor actor);

    List<Actor> getBySurname(String title);

    Iterable<Actor> showAllActors();

    void deleteActor(Integer id);

    Boolean checkIfExists(Integer id);

    Iterable<Actor> getAll(Integer pageNr, Integer howMany);
}
