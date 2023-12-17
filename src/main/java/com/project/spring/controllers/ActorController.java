package com.project.spring.controllers;

import com.project.spring.entities.Actor;
import com.project.spring.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping(value = "/{surname}")
    public List<Actor> getBySurname(@PathVariable String surname) {
        return actorService.getBySurname(surname);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Actor> showAll(){
        return actorService.showAllActors();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Actor> create(@RequestBody Actor actor){
        actorService.saveActor(actor);
        return ResponseEntity.ok().body(actor);
    }

    @DeleteMapping(value = "/delete/{id}")
    public RedirectView delete(@PathVariable Integer id){
        actorService.deleteActor(id);
        return new RedirectView("/actor/actorList", true);
    }

    @ApiIgnore
    @RequestMapping(value = "/actorList")
    public Iterable<Actor> redirect() {
        return actorService.showAllActors();
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Void> edit(@RequestBody Actor actor) {
        if (!actorService.checkIfExists(actor.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            actorService.saveActor(actor);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}
