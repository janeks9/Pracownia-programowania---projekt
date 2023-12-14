package project.Controllers;

import project.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Homepage controller.
 */
@RestController
@RequestMapping("/api")
public class IndexController {

    @Autowired
    //private ProductService productService;

    @GetMapping(value = "")
    String index() {
        return "index";
    }


    @PostMapping(value = "/generateModel", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        Film film1 = new Film("Pulp Fiction", "1994-05-21", 154, "USA");
        Film film2 = new Film("Inglorious Basterds", "2009-05-20", 153, "USA");
        Film film3 = new Film("Wilk z Wall Street", "2013-12-09", 179, "USA");
        Film film4 = new Film("Interstellar", "2014-10-26", 169, "USA");

        Director dir1 = new Director("Quentin", "Tarantino", "1963", "USA");
        Director dir2 = new Director("Martin", "Scorsese", "1942", "USA");
        Director dir3 = new Director("Christopher", "Nolan", "1970", "Wielka Brytania");

        Actor actor1 = new Actor("Bruce", "Willis", "1955", "USA");
        Actor actor2 = new Actor("Leonardo", "di Caprio", "1974", "USA");
        Actor actor3 = new Actor("Michael", "Caine", "1933", "Wielka Brytania");
        Actor actor4 = new Actor("Margot", "Robbie", "1990", "Australia");

        Genre genre1 = new Genre("Gangsterski");
        Genre genre2 = new Genre("Wojenny");
        Genre genre3 = new Genre("Biograficzny");
        Genre genre4 = new Genre("Science-fiction");

        Finances finances1 = new Finances(70000000, 321457747);

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

        finances1.setFilm(film1);


        return "Model Generated";
    }
}
