package com.project.spring.controllers;

import com.project.spring.entities.*;
import com.project.spring.services.*;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private DirectorService directorService;

    @Autowired
    private ActorService actorService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private FinancesService financesService;

    @GetMapping(value = "")
    String index() {
        return "index";
    }


    @PostMapping(value = "generateModel", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        Film film1 = new Film("Pulp Fiction", new LocalDate(1994, 5, 21), 154, "USA");
        Film film2 = new Film("Inglorious Basterds", new LocalDate(2009,5, 20), 153, "USA");
        Film film3 = new Film("Wilk z Wall Street", new LocalDate(2013, 12,9), 179, "USA");
        Film film4 = new Film("Interstellar", new LocalDate(2014, 10,26), 169, "USA");

        Director dir1 = new Director("Quentin", "Tarantino", new LocalDate(1963, 3, 27), "USA");
        Director dir2 = new Director("Martin", "Scorsese", new LocalDate(1942, 11, 17), "USA");
        Director dir3 = new Director("Christopher", "Nolan", new LocalDate(1970, 7, 30), "Wielka Brytania");

        Actor actor1 = new Actor("Bruce", "Willis", new LocalDate(1955, 3, 19), "USA");
        Actor actor2 = new Actor("Leonardo", "di Caprio", new LocalDate(1974, 11, 11), "USA");
        Actor actor3 = new Actor("Michael", "Caine", new LocalDate(1933, 3, 14), "Wielka Brytania");
        Actor actor4 = new Actor("Margot", "Robbie", new LocalDate(1990, 7, 2), "Australia");

        Genre genre1 = new Genre("Gangsterski");
        Genre genre2 = new Genre("Wojenny");
        Genre genre3 = new Genre("Biograficzny");
        Genre genre4 = new Genre("Science-fiction");

        //Finances finances1 = new Finances();

        film1.setDirector(dir1);
        film1.getActors().add(actor1);
        film1.getGenres().add(genre1);

        film2.setDirector(dir1);
        film2.getGenres().add(genre2);

        film3.setDirector(dir2);
        film3.getActors().add(actor2);
        film3.getActors().add(actor4);
        film3.getGenres().add(genre3);

        film4.setDirector(dir3);
        film4.getActors().add(actor3);
        film4.getGenres().add(genre4);

        filmService.saveFilm(film1);
        filmService.saveFilm(film2);
        filmService.saveFilm(film3);
        filmService.saveFilm(film4);

        directorService.saveDirector(dir1);
        directorService.saveDirector(dir2);
        directorService.saveDirector(dir3);

        actorService.saveActor(actor1);
        actorService.saveActor(actor2);
        actorService.saveActor(actor3);
        actorService.saveActor(actor4);

        genreService.saveGenre(genre1);
        genreService.saveGenre(genre2);
        genreService.saveGenre(genre3);
        genreService.saveGenre(genre4);

        //financesService.saveFinances(finances1);

        return "Model Generated";
    }
}
