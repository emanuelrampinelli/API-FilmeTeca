package com.api.filmeteca.controller;

import com.api.filmeteca.model.Filme;
import com.api.filmeteca.service.FilmeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/muito_veloz_sapoha")
    public Filme teste() {
        return filmeService.getListaInicial();
    }

}
