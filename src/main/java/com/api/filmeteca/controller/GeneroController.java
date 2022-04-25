package com.api.filmeteca.controller;

import com.api.filmeteca.service.GeneroService;
import com.api.filmeteca.util.Generos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping("/list")
    public Generos getListGeneros() {

        return generoService.getListGeneros();
    }

}
