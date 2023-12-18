package com.project.spring.controllers;

import com.project.spring.entities.Finances;
import com.project.spring.services.FinancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;
import java.util.Optional;

@RestController
@RequestMapping("/finances")
public class FinancesController {

    @Autowired
    private FinancesService financesService;

    @GetMapping(value = "/finances/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Finances> getById(@PathVariable Integer id) {
        return financesService.getById(id);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Finances> showAll(){
        return financesService.showAllFinances();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Finances> create(@RequestBody Finances finances){
        financesService.saveFinances(finances);
        return ResponseEntity.ok().body(finances);
    }

    @DeleteMapping(value = "/delete/{id}")
    public RedirectView delete(@PathVariable Integer id){
        financesService.deleteFinances(id);
        return new RedirectView("/genre/genreList", true);
    }

    @ApiIgnore
    @RequestMapping(value = "/genreList")
    public Iterable<Finances> redirect() {
        return financesService.showAllFinances();
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Void> edit(@RequestBody Finances finances) {
        if (!financesService.checkIfExists(finances.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            financesService.saveFinances(finances);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
