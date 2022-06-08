package com.api.filmeteca.controller;

import com.api.filmeteca.dto.FilmeDto;
import com.api.filmeteca.dto.FilmotecaDto;
import com.api.filmeteca.service.FilmeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/populares/{index}")
    public FilmotecaDto getFilmesPopulares(@PathVariable(value = "index") String index) {
        return filmeService.getFilmesPopulares(index);
    }

    @GetMapping("/{id}")
    public FilmeDto getFilme(@PathVariable(value = "id") String id) {
        return filmeService.getFilme(id);
    }

    @GetMapping("/search/{texto}")
    public FilmotecaDto procurarFilmes(@PathVariable(value = "texto") String texto) {
        return filmeService.procurarFilmes(texto);
    }

}
