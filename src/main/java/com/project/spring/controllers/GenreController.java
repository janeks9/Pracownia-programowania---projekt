package com.project.spring.controllers;

import com.project.spring.entities.Genre;
import com.project.spring.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GenreController {
    @Autowired
    private GenreService genreService;

    //Check value in url to int
    @GetMapping(value = "/genre/{id}")
    public List<Genre> getById(@PathVariable int id) {
        return genreService.getById(id);
    }
}
