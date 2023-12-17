package com.project.spring.controllers;

import com.project.spring.entities.Director;
import com.project.spring.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping(value = "/director/{surname}")
    public List<Director> getBySurname(@PathVariable String surname) {
        return directorService.getBySurname(surname);
    }
}
