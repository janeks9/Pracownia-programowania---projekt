package com.project.spring.controllers;

import com.project.spring.entities.Director;
import com.project.spring.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping(value = "/{surname}")
    public List<Director> getBySurname(@PathVariable String surname) {
        return directorService.getBySurname(surname);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Director> showAll(){
        return directorService.showAllDirectors();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Director> create(@RequestBody Director director){
        directorService.saveDirector(director);
        return ResponseEntity.ok().body(director);
    }

    @DeleteMapping(value = "/delete/{id}")
    public RedirectView delete(@PathVariable Integer id){
        directorService.deleteDirector(id);
        return new RedirectView("/director/directorsList", true);
    }

    @ApiIgnore
    @RequestMapping(value = "/directorsList")
    public Iterable<Director> redirect() {
        return directorService.showAllDirectors();
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Void> edit(@RequestBody Director director) {
        if (!directorService.checkIfExists(director.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            directorService.saveDirector(director);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}
