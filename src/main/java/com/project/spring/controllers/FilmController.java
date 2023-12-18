package com.project.spring.controllers;

import com.project.spring.entities.Film;
import com.project.spring.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Film> showAll(){
        return filmService.showAllFilms();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Film> create(@RequestBody Film film){
        filmService.saveFilm(film);
        return ResponseEntity.ok().body(film);
    }

    @DeleteMapping(value = "/delete/{id}")
    public RedirectView delete(@PathVariable Integer id){
        filmService.deleteFilm(id);
        return new RedirectView("/film/filmList", true);
    }

    @ApiIgnore
    @RequestMapping(value = "/filmList")
    public Iterable<Film> redirect() {
        return filmService.showAllFilms();
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Void> edit(@RequestBody Film film) {
        if (!filmService.checkIfExists(film.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            filmService.saveFilm(film);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @GetMapping(value = "/long", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> longFilms(){
        return filmService.longFilms();
    }

    @GetMapping(value = "/byTitle/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> getByTitle(@PathVariable String title){
        return filmService.getByTitle(title);
    }
}
