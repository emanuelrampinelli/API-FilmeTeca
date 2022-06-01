package com.api.filmeteca.controller;

import java.util.List;

import com.api.filmeteca.dto.ComentarioDto;
import com.api.filmeteca.model.Comentario;
import com.api.filmeteca.service.ComentarioService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public List<Comentario> findAll() {
        return comentarioService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ComentarioDto comentarioDto) {

        Comentario comentario = new Comentario();
        BeanUtils.copyProperties(comentarioDto, comentario);

        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.save(comentario));
    }

}
