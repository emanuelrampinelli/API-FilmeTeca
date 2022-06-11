package com.api.filmeteca.controller;

import java.util.Date;
import java.util.List;

import com.api.filmeteca.dto.ComentarioDto;
import com.api.filmeteca.dto.UsuarioDto;
import com.api.filmeteca.model.Comentario;
import com.api.filmeteca.model.Usuario;
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

import javax.validation.Valid;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public  ResponseEntity<Object> findComentarioPorUsuario(@Valid @RequestBody UsuarioDto usuarioDto){

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);

        return ResponseEntity.status(HttpStatus.OK).body(comentarioService.findComentario(usuario));

    }

    @PostMapping
    public ResponseEntity<Object> saveComentario(@Valid @RequestBody ComentarioDto comentarioDto) {

        Comentario comentario = new Comentario();
        BeanUtils.copyProperties(comentarioDto, comentario);
        comentario.setDataCadastro(new Date());

        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.saveComentario(comentario));
    }

}
