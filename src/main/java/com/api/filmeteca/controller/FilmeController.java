package com.api.filmeteca.controller;

import com.api.filmeteca.model.Filme;
import com.api.filmeteca.service.FilmeService;
import com.api.filmeteca.util.Filmoteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filme")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/populares")
    public Filmoteca getFilmesPopulares() {
        return filmeService.getFilmesPopulares(1);
    }

    @GetMapping("")
    public Filme getFilme(@RequestParam String id) {
        return filmeService.getFilme(id);
    }

    @GetMapping("diretor")
    public Filme getDiretorFilme(@RequestParam String id) {
        // https://api.themoviedb.org/3/movie/414906/credits?api_key=d7251e004d1f3faea8a9b0f9405646b6&language=pt-BR
        // "job": "Director"
        // Return name
        return null;
    }

}
