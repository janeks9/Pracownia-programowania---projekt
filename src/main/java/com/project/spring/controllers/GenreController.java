package com.project.spring.controllers;

import com.project.spring.entities.Genre;
import com.project.spring.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Optional;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping(value = "/{id}")
    public Optional<Genre> getById(@PathVariable int id) {
        return genreService.getById(id);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Genre> showAll(){
        return genreService.showAllGenres();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Genre> create(@RequestBody Genre genre){
        genreService.saveGenre(genre);
        return ResponseEntity.ok().body(genre);
    }

    @DeleteMapping(value = "/delete/{id}")
    public RedirectView delete(@PathVariable Integer id){
        genreService.deleteGenre(id);
        return new RedirectView("/genre/genreList", true);
    }

    @ApiIgnore
    @RequestMapping(value = "/genreList")
    public Iterable<Genre> redirect() {
        return genreService.showAllGenres();
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Void> edit(@RequestBody Genre genre) {
        if (!genreService.checkIfExists(genre.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            genreService.saveGenre(genre);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
