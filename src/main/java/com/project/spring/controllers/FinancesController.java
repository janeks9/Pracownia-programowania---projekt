package com.project.spring.controllers;

import com.project.spring.services.FinancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finances")
public class FinancesController {

    @Autowired
    private FinancesService financesService;

    /*@GetMapping(value = "/budget", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseBody
    public */
}
