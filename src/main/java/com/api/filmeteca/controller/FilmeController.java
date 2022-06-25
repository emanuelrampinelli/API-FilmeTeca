package com.api.filmeteca.controller;
import com.api.filmeteca.service.FilmeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> getFilmesPopulares(@PathVariable(value = "index") String index) {

        return ResponseEntity.status(HttpStatus.OK).body(filmeService.getFilmesPopulares(index));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>  getFilme(@PathVariable(value = "id") String id) {

        return ResponseEntity.status(HttpStatus.OK).body(filmeService.getFilme(id));

    }

    @GetMapping("/search/{texto}")
    public ResponseEntity<Object> procurarFilmes(@PathVariable(value = "texto") String texto) {

        return ResponseEntity.status(HttpStatus.OK).body(filmeService.procurarFilmes(texto));
    }

}
