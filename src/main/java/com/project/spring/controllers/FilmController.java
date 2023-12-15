package com.project.spring.controllers;

import com.project.spring.entities.Film;
import com.project.spring.services.FilmService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping(value = "")
    String index() {
        return "index";
    }

    @PostMapping(value = "generateModel", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        Film film1 = new Film("Pulp Fiction", new LocalDate(1994, 5, 23), 154, "USA");
        filmService.saveFilm(film1);

        return "Model Generated";
    }
}
